package com.techelevator.controller;

import com.techelevator.model.Beer;
import com.techelevator.model.BeerReview;
import com.techelevator.service.BeerReviewService;
import com.techelevator.service.BeerReviewServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
    private BeerReviewService reviewService;
    public BeerReviewController(BeerReviewServiceImpl reviewServiceImpl) {
        this.reviewService = reviewServiceImpl;
    }
    @GetMapping("/beers/reviews")
    public List<BeerReview> getAllBeerReviews() {
        return reviewService.getAllBeerReviews();
    }
    @GetMapping("/beers/reviews/{id}")
    public BeerReview beerReviewByID(@PathVariable("id") int reviewId) {
        return reviewService.getBeerReviewById(reviewId);
    }
    @GetMapping("beers/myreviews")
    public List<BeerReview> myBeerReviews(Principal principal) {
        List<BeerReview> myBeerReviews = reviewService.getMyBeerReviews(principal);
        return myBeerReviews;
    }
    @PostMapping("beers/reviews")
    @ResponseStatus(HttpStatus.CREATED)
    public BeerReview addBeerReview(BeerReview beerReview, Principal principal) {
        BeerReview newBeerReview = reviewService.createBeerReview(beerReview, principal);
        return newBeerReview;
    }
    @PutMapping("/beers/reviews/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BeerReview updateBeerReview(BeerReview beerReview, Principal principal) {
        BeerReview updatedBeerReview = reviewService.updateBeerReview(beerReview, principal);
        return updatedBeerReview;
    }

    @DeleteMapping("beers/reviews/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeerReview(@PathVariable("id") int reviewId, Principal principal) {
        reviewService.deleteBeerReview(reviewId, principal);
    }

}
