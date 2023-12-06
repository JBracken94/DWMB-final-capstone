package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Beer;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.List;

@Component
public class JdbcBeerDao implements BeerDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcBeerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Beer getBeerById(int beerId) {
        Beer beer = null;
        beer.setBeerId(beerId);
        String sql = "SELECT beer_id, beer_name, brewery_id, beer_type, abv, label_image, desctiption " +
                    "FROM beer WHERE beer_id = ?;";
        try {
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, beerId);
            if (result.next()) {
                beer = mapRowToBeer(result);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return beer;
    }

    @Override
    public List<Beer> getBeersByBreweryId(int breweryId) {
        return null;
    }

    @Override
    public List<Beer> getSavedBeers(Principal principal) {
        return null;
    }

    @Override
    public Beer addBeerToSaved(int beerId, Principal principal) {
        return null;
    }

    @Override
    public Beer createBeer(Beer beer, Principal principal) {
        return null;
    }

    @Override
    public Beer updateBeer(Beer beer, Principal principal) {
        return null;
    }

    @Override
    public void deleteSavedBeer(int beerId, Principal principal) {

    }

    @Override
    public void deleteBeer(int beerId) {

    }
    private Beer mapRowToBeer (SqlRowSet rs) {
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
}
