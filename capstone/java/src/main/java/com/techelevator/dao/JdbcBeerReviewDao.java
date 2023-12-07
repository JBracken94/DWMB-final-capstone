package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.BeerReview;
import com.techelevator.model.User;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcBeerReviewDao implements BeerReviewDao {
    private JdbcTemplate jdbcTemplate;
    private JdbcUserDao jdbcUserDao;
    public JdbcBeerReviewDao(JdbcTemplate jdbcTemplate, JdbcUserDao jdbcUserDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.jdbcUserDao = jdbcUserDao;
    }
    @Override
    public List<BeerReview> getAllBeerReviews() {
        List<BeerReview> allReviews = new ArrayList<>();
        String sql = "SELECT beer_review_id, beer_id, reviewer_id, beer_rating, beer_review, date_posted " +
                "FROM beer_review;";
        try {
            SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
            while (rs.next()) {
                allReviews.add(mapRowToBeerReview(rs));
            }
            return allReviews;
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.");
        }
    }

    @Override
    public BeerReview getBeerReviewById(int beerReviewId) {
        BeerReview beerReview = null;
        String sql = "SELECT beer_review_id, beer_id, reviewer_id, beer_rating, beer_review, date_posted " +
                    "FROM beer_review WHERE beer_review_id = ?;";
        try {
            SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, beerReviewId);
            if (rs.next()) {
                beerReview = mapRowToBeerReview(rs);
            }
            return beerReview;
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.");
        }
    }

    @Override
    public List<BeerReview> getMyBeerReviews(Principal principal) {
        List<BeerReview> beerReviews = new ArrayList<>();
        String sql = "SELECT beer_review_id, beer_id, reviewer_id, beer_rating, beer_review, date_posted " +
                    "FROM beer_review WHERE reviewer_id = ?;";
        try {
            User user = jdbcUserDao.getUserByUsername(principal.getName());
            SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, user.getId());
            while (rs.next()) {
                BeerReview beerReview = mapRowToBeerReview(rs);
                beerReviews.add(beerReview);
            }
            return beerReviews;
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.");
        }
    }

    @Override
    public BeerReview createBeerReview(BeerReview newBeerReview, Principal principal) { // catch DIV
        String sql = "INSERT INTO beer_review (beer_id, reviewer_id, beer_rating, beer_review, date_posted) " +
                    "VALUES (?,?,?,?,NOW()) RETURNING beer_review_id;";
        try {
            User user = jdbcUserDao.getUserByUsername(principal.getName());
            int createdId = jdbcTemplate.queryForObject(sql, int.class, newBeerReview.getBeerId(), user.getId(), newBeerReview.getBeerRating(),
                                                newBeerReview.getBeerReview());
            return getBeerReviewById(createdId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.");
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data Integrity Violation");
        }
    }

    @Override
    public BeerReview updateBeerReview(BeerReview beerReview, Principal principal) { // catch DIV
        String sql = "UPDATE beer_review " +
                "SET ";
        return null;
    }

    @Override
    public void deleteBeerReview(int beerReviewId) { // catch DIV (shouldn't be an issue)
        String sql = "DELETE FROM beer_review WHERE beer_review_id = ?;";
        try {
            int rowsAffected = jdbcTemplate.update(sql, int.class, beerReviewId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.");
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data Integrity Violation");
        }
    }
    public BeerReview mapRowToBeerReview(SqlRowSet rs) {
        BeerReview beerReview = new BeerReview(
                rs.getInt("beer_review_id"),
                rs.getInt("beer_id"),
                rs.getInt("reviewer_id"),
                rs.getDouble("beer_rating"),
                rs.getString("beer_review"),
                rs.getTimestamp("date_posted").toLocalDateTime()
        );
        return beerReview;
    }
}
