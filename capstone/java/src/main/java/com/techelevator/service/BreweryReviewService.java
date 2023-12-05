package com.techelevator.service;

import com.techelevator.model.BreweryReview;

import java.security.Principal;
import java.util.List;

public interface BreweryReviewService {
    public BreweryReview getBreweryReviewById(int brewReviewId) throws InterruptedException;
    public List<BreweryReview> getReviewsByUserId(int reviewerId) throws InterruptedException;
    public BreweryReview createBreweryReview(BreweryReview newBrewReview, Principal principal);
    public BreweryReview updateBreweryReview(int brewReviewId, BreweryReview updatedBrewReview, Principal principal);
    public void deleteBreweryReview(int brewReviewId, Principal principal);
}
