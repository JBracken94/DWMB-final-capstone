package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Beer;
import com.techelevator.model.BrewSearchDTO;
import com.techelevator.model.Brewery;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.security.Timestamp;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Component
public class JdbcBreweryDao implements BreweryDao {

    // Instance Variables/Properties
    private JdbcTemplate jdbcTemplate;



    // Constructors
    public JdbcBreweryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    // Methods
    @Override
    public Brewery getBreweryById (int breweryId) {
        Brewery brewery = null;
        brewery.setBreweryId(breweryId);
        String sql = "SELECT brewery_id, brewery_name, street_address, city, state, zipcode," +
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
        return null;
    }

    @Override
    public List<Brewery> searchBreweries(BrewSearchDTO searchTerms) {
        return null;
    }

    @Override
    public List<Brewery> getSavedBreweries(Principal principal) {
        return null;
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
        Brewery brewery = new Brewery(
                rs.getInt("brewery_id"),
                rs.getString("brewery_name"),
                rs.getString("street_address"),
                rs.getString("city"),
                rs.getString("state"),
                rs.getString("zipcode"),
                //Below getObject call/conversion from:
                //https://stackoverflow.com/questions/51632735/jdbc-result-set-retrieve-localdatetime
                rs.getObject("date_est", LocalDateTime.class),
                rs.getString("phone_number"),
                rs.getString("about_us"),
                rs.getString("website"),
                rs.getString("logo_image"),
                rs.getInt("founder_id")
        );
        return brewery;
    }





}
