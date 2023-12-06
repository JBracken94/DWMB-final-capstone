package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.exception.ServiceException;
import com.techelevator.model.Beer;
import com.techelevator.model.FavoriteBeer;
import com.techelevator.model.User;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcBeerDao implements BeerDao {
    private JdbcTemplate jdbcTemplate;
    private JdbcUserDao jdbcUserDao;

    public JdbcBeerDao(JdbcTemplate jdbcTemplate, JdbcUserDao jdbcUserDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.jdbcUserDao = jdbcUserDao;
    }

    @Override
    public Beer getBeerById(int beerId) {
        Beer beer = null;
        String sql = "SELECT beer_id, beer_name, brewery_id, beer_type, abv, label_image, description " +
                "FROM beer WHERE beer_id = ?;";
        try {
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, beerId);
            if (result.next()) {
                beer = mapRowToBeer(result);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        }
        return beer;
    }

    @Override
    public List<Beer> getBeersByBreweryId(int breweryId) {
        List<Beer> beers = new ArrayList<>();
        String sql = "SELECT beer_id, beer_name, brewery_id, beer_type, abv, label_image, description " +
                "FROM beer WHERE brewery_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, breweryId);
            while (results.next()) {
                Beer beer = mapRowToBeer(results);
                beers.add(beer);
            }
            return beers;
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        }
    }

    @Override
    public List<Beer> getSavedBeers(Principal principal) {
        List<Beer> myBeers = new ArrayList<>();
        String sql = "SELECT beer_id FROM favorite_beer WHERE user_id = ?;";
        try {
            User user = jdbcUserDao.getUserByUsername(principal.getName());
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, user.getId());
            while (results.next()) {
                myBeers.add(getBeerById(results.getInt("beer_id")));
            }
            return myBeers;
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        }
    }

    @Override
    public Beer addBeerToSaved(int beerId, Principal principal) { //TODO:: PREVENT DOUBLE ENTRIES - DIV exception
        Beer beerToSave = null;
        String savedBeerSql = "INSERT INTO favorite_beer (user_id, beer_id) " +
                "VALUES (?,?) RETURNING fav_beer_id;";
        try {
            User user = jdbcUserDao.getUserByUsername(principal.getName());
            int favBeerEntryId = jdbcTemplate.queryForObject(savedBeerSql, int.class, user.getId(), beerId);
            if (favBeerEntryId != 0) {
                return getBeerById(beerId);
            } else {
                throw new DaoException("There was an issue adding your beer. Please try again.");
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data Integrity Violation", e);
        }
    }

    @Override
    public Beer createBeer(Beer beer, Principal principal) { // TODO:: add validation so only the founder can add beer
        // TODO consider getBreweryByFounder for brewery_id
        String sql = "INSERT INTO beer (beer_name, brewery_id, beer_type, abv, label_image, description) " +
                "VALUES (?,?,?,?,?,?) RETURNING beer_id;";
        try {
            int newBeerId = jdbcTemplate.queryForObject(sql, int.class, beer.getBeerName(), beer.getBreweryId(), beer.getBeerType(),
                    beer.getAbv(), beer.getLabelImage(), beer.getDescription());

            return getBeerById(newBeerId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data Integrity Violation", e);
        }
    }

    @Override
    public Beer updateBeer(Beer beer, Principal principal) { // TODO validate beer belongs to brewer before update :: implement

        return null;
    }

    @Override
    public void deleteSavedBeer(int beerId, Principal principal) { // TODO validate beer belongs to brewer
        User user = jdbcUserDao.getUserByUsername(principal.getName());
        String sql = "DELETE FROM favorite_beer WHERE beer_id = ? AND user_id = ?;";
        try {
            Beer beerToDelete = getBeerById(beerId);

            int rowsAffected = jdbcTemplate.update(sql, beerId, user.getId());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.");
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data Integrity Violation");
        }

    }

    @Override
    public void deleteBeer(int beerId) { //TODO
        String favBeerSql = "DELETE FROM favorite_beer WHERE beer_id = ?;"; // deletes from favorite_beer
        String beerSql = "DELETE FROM beer WHERE beer_id = ?;"; // deletes from beer
        try {
            jdbcTemplate.update(favBeerSql, beerId);
            jdbcTemplate.update(beerSql, beerId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.");
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data Integrity Violation");
        }

    }

    private Beer mapRowToBeer(SqlRowSet rs) {
        Beer beer = new Beer(
                rs.getInt("beer_id"),
                rs.getString("beer_name"),
                rs.getInt("brewery_id"),
                rs.getString("beer_type"),
                rs.getDouble("abv"),
                rs.getString("label_image"),
                rs.getString("description")
        );
        return beer;
    }

    private FavoriteBeer mapRowToFavoriteBeer(SqlRowSet rs) {
        FavoriteBeer favBeer = new FavoriteBeer(
                rs.getInt("fav_beer_id"),
                rs.getInt("user_id"),
                rs.getInt("beer_id")
        );
        return favBeer;
    }
}
