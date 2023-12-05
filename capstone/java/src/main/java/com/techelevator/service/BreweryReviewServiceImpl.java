package com.techelevator.service;

import com.techelevator.model.BreweryReview;

import java.security.Principal;
import java.util.List;

public class BreweryReviewServiceImpl implements BreweryReviewService {

    @Override
    public BreweryReview getBreweryReviewById(int brewReviewId) {
        return null;
    }

    @Override
    public List<BreweryReview> getMyReviews(Principal principal) {
        return null;
    }

    @Override
    public BreweryReview createBreweryReview(BreweryReview newBrewReview, Principal principal) {
        return null;
    }

    @Override
    public BreweryReview updateBreweryReview(int brewReviewId, BreweryReview updatedBrewReview, Principal principal) {
        return null;
    }

    @Override
    public void deleteBreweryReview(int brewReviewId, Principal principal) {

    }
}
