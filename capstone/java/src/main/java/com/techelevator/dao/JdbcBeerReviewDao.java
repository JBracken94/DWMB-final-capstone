package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.BeerReview;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

public class JdbcBeerReviewDao implements BeerReviewDao {
    private JdbcTemplate jdbcTemplate;
    public JdbcBeerReviewDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
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
    public BeerReview getBeerReviewById(int breweryReviewId) {
        return null;
    }

    @Override
    public List<BeerReview> getMyBeerReviews(Principal principal) {
        return null;
    }

    @Override
    public BeerReview createBeerReview(BeerReview newBeerReview) {
        return null;
    }

    @Override
    public BeerReview updateBeerReview(BeerReview beerReview) {
        return null;
    }

    @Override
    public void deleteBeerReview(int beerReviewId) {

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
