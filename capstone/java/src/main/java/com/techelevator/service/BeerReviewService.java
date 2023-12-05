package com.techelevator.service;

import com.techelevator.model.BeerReview;

import java.security.Principal;
import java.util.List;

public interface BeerReviewService {
    public BeerReview getBeerReviewById(int beerReviewId);

    public List<BeerReview> getMyBeerReviews(Principal principal);
    public BeerReview createBeerReview(BeerReview newBeerReview);
    public BeerReview updateBeerReview(BeerReview updatedBeerReview);
    public void deleteBeerReview(int beerReviewId);
}
