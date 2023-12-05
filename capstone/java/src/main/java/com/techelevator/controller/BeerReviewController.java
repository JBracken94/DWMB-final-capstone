package com.techelevator.controller;

import com.techelevator.service.BeerReviewServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
public class BeerReviewController {
    private BeerReviewServiceImpl reviewServiceImpl;
    public BeerReviewController(BeerReviewServiceImpl reviewServiceImpl) {
        this.reviewServiceImpl = reviewServiceImpl;
    }
    @GetMapping("/beers/reviews/{id}")
    public BigDecimal beerReviewByID(@PathVariable("id") int reviewId) {
        return BigDecimal.valueOf(reviewId);
    }
    @GetMapping("beers/myreviews")
    public List<String> myBeerReviews(Principal principal) {
        List<String> myBeerReviews = new ArrayList<>();
        myBeerReviews.add(principal.getName());
        return myBeerReviews;
    }

    @PostMapping("beers/reviews")
    public String addBeerReview(String beerReview) {
        String result = beerReview + "testbeer";
        return result;
    }

}
