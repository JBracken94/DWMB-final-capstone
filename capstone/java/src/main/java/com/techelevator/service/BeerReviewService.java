package com.techelevator.service;

import com.techelevator.model.BeerReview;

import java.security.Principal;
import java.util.List;

public interface BeerReviewService {
    public BeerReview getBeerReviewById(int beerReviewId) throws InterruptedException;

    public List<BeerReview> getMyBeerReviews(Principal principal) throws InterruptedException;
    public BeerReview createBeerReview(BeerReview newBeerReview);
}
