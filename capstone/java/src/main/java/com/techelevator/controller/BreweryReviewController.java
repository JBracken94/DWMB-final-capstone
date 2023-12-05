package com.techelevator.controller;

import com.techelevator.service.BreweryReviewServiceImpl;
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
public class BreweryReviewController {
    private BreweryReviewServiceImpl breweryReviewService;
    @GetMapping("/breweries/reviews/{id}")
    public BigDecimal breweryReviewByID(@PathVariable("id") int breweryId) {
        return BigDecimal.valueOf(breweryId);
    }
    @GetMapping("breweries/myreviews")
    public List<String> myBreweryReviews(Principal principal) {
        List<String> myBreweryReviews = new ArrayList<>();
        myBreweryReviews.add(principal.getName());
        return myBreweryReviews;
    }
    @PostMapping("breweries/reviews")
    public String addReview(String brewReview) {
        String result = brewReview + "testbrew";
        return result;
    }
}
