package com.techelevator.controller;

import com.techelevator.model.BreweryReview;
import com.techelevator.service.BreweryReviewService;
import com.techelevator.service.BreweryReviewServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
public class BreweryReviewController {
    private BreweryReviewService breweryReviewService;

    @GetMapping("/breweries/reviews/{id}")
    public BreweryReview breweryReviewByID(@PathVariable("id") int breweryReviewId) {
        BreweryReview review = breweryReviewService.getBreweryReviewById(breweryReviewId);
        return review;
    }
    @GetMapping("breweries/myreviews")
    public List<BreweryReview> myBreweryReviews(Principal principal) {
        List<BreweryReview> myBreweryReviews = breweryReviewService.getMyReviews(principal);
        return myBreweryReviews;
    }
    @PostMapping("breweries/reviews")
    @ResponseStatus(HttpStatus.CREATED)
    public BreweryReview addReview(BreweryReview brewReview, Principal principal) {
        BreweryReview newReview = breweryReviewService.createBreweryReview(brewReview, principal);
        return newReview;
    }
    @PutMapping("breweries/reviews/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BreweryReview updateBreweryReview(BreweryReview breweryReview, Principal principal){
        BreweryReview updatedReview = breweryReviewService.updateBreweryReview(breweryReview, principal);
        return  updatedReview;
    }
    @DeleteMapping("breweries/review/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReview(int reviewId, Principal principal) {
        breweryReviewService.deleteBreweryReview(reviewId, principal);
    }
}
