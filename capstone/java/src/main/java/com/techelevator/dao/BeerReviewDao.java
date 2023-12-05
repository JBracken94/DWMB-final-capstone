package com.techelevator.dao;

import com.techelevator.model.BeerReview;

import java.security.Principal;
import java.util.List;

public interface BeerReviewDao {
    BeerReview getBeerReviewById (int breweryReviewId);
    List<BeerReview> getMyBeerReviews(Principal principal);
    BeerReview createBeerReview(BeerReview newBeerReview);
    BeerReview updateBeerReview(BeerReview beerReview);
    void deleteBeerReview(int beerReviewId);
}
