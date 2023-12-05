package com.techelevator.controller;

import com.techelevator.model.BreweryReview;
import com.techelevator.service.BreweryReviewServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.security.Principal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
public class BreweryReviewController {
    private BreweryReviewServiceImpl breweryReviewService;
    private BreweryReview testbrewreview = new BreweryReview(1,1,1,5,"wowsuchbrewery", Date.from(Instant.now()));


    @GetMapping("/breweries/reviews/{id}")
    public BreweryReview breweryReviewByID(@PathVariable("id") int breweryId) {
        return testbrewreview;
    }
    @GetMapping("breweries/myreviews")
    public List<BreweryReview> myBreweryReviews(Principal principal) {
        List<BreweryReview> myBreweryReviews = new ArrayList<>();
        myBreweryReviews.add(testbrewreview);
        return myBreweryReviews;
    }
    @PostMapping("breweries/reviews")
    public BreweryReview addReview(BreweryReview brewReview) {
        BreweryReview result = brewReview;
        return result;
    }
}
