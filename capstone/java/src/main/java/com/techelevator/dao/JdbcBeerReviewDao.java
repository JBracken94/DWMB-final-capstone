package com.techelevator.dao;

import com.techelevator.model.BeerReview;

import java.security.Principal;
import java.util.List;

public class JdbcBeerReviewDao implements BeerReviewDao{
    @Override
    public List<BeerReview> getAllBeerReviews() {
        return null;
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
}
