package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Beer;
import com.techelevator.model.BrewSearchDTO;
import com.techelevator.model.Brewery;
import com.techelevator.model.User;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.security.Timestamp;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class JdbcBreweryDao implements BreweryDao {

    // Instance Variables/Properties
    private JdbcTemplate jdbcTemplate;
    private JdbcUserDao jdbcUserDao;



    // Constructors
    public JdbcBreweryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.jdbcUserDao = jdbcUserDao;
    }



    // Methods
    @Override
    public Brewery getBreweryById (int breweryId) {
        Brewery brewery = null;
        brewery.setBreweryId(breweryId);
        String sql = "SELECT brewery_id, brewery_name, street_address, city, state, zip_code," +
                     " date_est, phone_number, about_us, website, logo_image, founder_id " +
                "FROM brewery WHERE brewery_id = ?;";
        try {
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, breweryId);
            if (result.next()) {
                brewery = mapRowToBrewery(result);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return brewery;
    }

    @Override
    public List<Brewery> getAllBreweries() {
        List<Brewery> breweries = new ArrayList<>();
        String sql = "SELECT brewery_id, brewery_name, street_address, city, state, zip_code," +
                " date_est, phone_number, about_us, website, logo_image, founder_id " +
                "FROM brewery;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Brewery brewery = mapRowToBrewery(results);
                breweries.add(brewery);
            }
            return breweries;
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        }
    }

    @Override
    public List<Brewery> searchBreweries(BrewSearchDTO searchTerms) {
        return null;
    }

    @Override
    public List<Brewery> getSavedBreweries(Principal principal) {
        List<Brewery> myBreweries = new ArrayList<>();
        String sql = "SELECT brewery_id FROM favorite_brewery WHERE user_id = ?;";
        try {
            User user = jdbcUserDao.getUserByUsername(principal.getName());
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, user.getId());
            while (results.next()) {
                myBreweries.add(getBreweryById(results.getInt("brewery_id")));
            }
            return myBreweries;
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        }
    }

    @Override
    public Brewery createBrewery(Brewery newBrewery, Principal principal) {
        return null;
    }

    @Override
    public Brewery updateBrewery(Brewery updatedBrewery, Principal principal) {
        return null;
    }

    @Override
    public void deleteBrewery(int breweryId, Principal principal) {
    }


    // Helper Methods
    private Brewery mapRowToBrewery (SqlRowSet rs) {
        Brewery brewery = new Brewery();
        brewery.setBreweryId(rs.getInt("brewery_id"));
        brewery.setBreweryName(rs.getString("brewery_name"));
        brewery.setStreetAddress(rs.getString("street_address"));
        brewery.setCity(rs.getString("city"));
        brewery.setState(rs.getString("state"));
        brewery.setZipcode(rs.getString("zip_code"));

        if (rs.getTimestamp("date_est") != null) {
        brewery.setDateEst(rs.getTimestamp("date_est").toLocalDateTime());
        }

        brewery.setPhoneNumber(rs.getString("phone_number"));
        brewery.setAboutUs(rs.getString("about_us"));
        brewery.setWebsite(rs.getString("website"));
        brewery.setLogoImage(rs.getString("logo_image"));
        brewery.setFounderId(rs.getInt("founder_id"));
        return brewery;
    }





}
