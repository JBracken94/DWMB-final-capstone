package com.techelevator.controller;

import com.techelevator.model.Beer;
import com.techelevator.model.BeerReview;
import com.techelevator.service.BeerReviewServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.security.Principal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
public class BeerReviewController {
    private BeerReviewServiceImpl reviewServiceImpl;
    private BeerReview testReviewBeer = new BeerReview(1, 1, 1, 5, "wow such beer", Date.from(Instant.now()));
    public BeerReviewController(BeerReviewServiceImpl reviewServiceImpl) {
        this.reviewServiceImpl = reviewServiceImpl;
    }
    @GetMapping("/beers/reviews/{id}")
    public BeerReview beerReviewByID(@PathVariable("id") int reviewId) {
        return testReviewBeer;
    }
    @GetMapping("beers/myreviews")
    public List<BeerReview> myBeerReviews(Principal principal) {
        List<BeerReview> myBeerReviews = new ArrayList<>();
        myBeerReviews.add(testReviewBeer);
        return myBeerReviews;
    }

    @PostMapping("beers/reviews")
    public BeerReview addBeerReview(BeerReview beerReview) {
        BeerReview result = beerReview;
        return result;
    }

}
