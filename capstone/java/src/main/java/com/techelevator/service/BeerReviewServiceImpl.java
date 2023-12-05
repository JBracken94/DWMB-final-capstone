package com.techelevator.service;

import com.techelevator.model.BeerReview;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class BeerReviewServiceImpl implements BeerReviewService {
    @Override
    public BeerReview getBeerReviewById(int beerReviewId) throws InterruptedException {
        System.out.println("dao.getreviewbyreviewid");
        return null;
    }

    @Override
    public List<BeerReview> getMyBeerReviews(Principal principal) throws InterruptedException {
        System.out.println("reviewsbyuserId");
        return null;
    }

    @Override
    public BeerReview createBeerReview(BeerReview newBeerReview) {
        System.out.println("create new review");
        return null;
    }
}
