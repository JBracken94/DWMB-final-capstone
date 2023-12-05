package com.techelevator.model;

import java.util.Date;

public class BreweryReview {

    // Instance Variables/Properties
    private int breweryReviewId;
    private int breweryId;
    private int reviewerId;
    private int breweryRating;
    private String breweryReview;
    private Date datePosted;



    // Constructors
    public BreweryReview() {
    }

    public BreweryReview(int reviewId, int breweryId, int reviewerId, int breweryRating, String breweryReview, Date datePosted) {
        this.breweryReviewId = reviewId;
        this.breweryId = breweryId;
        this.reviewerId = reviewerId;
        this.breweryRating = breweryRating;
        this.breweryReview = breweryReview;
        this.datePosted = datePosted;
    }



    // Getters and Setters
    public int getReviewId() {
        return breweryReviewId;
    }

    public void setReviewId(int reviewId) {
        this.breweryReviewId = reviewId;
    }

    public int getBreweryId() {
        return breweryId;
    }

    public void setBreweryId(int breweryId) {
        this.breweryId = breweryId;
    }

    public int getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(int reviewerId) {
        this.reviewerId = reviewerId;
    }

    public int getBreweryRating() {
        return breweryRating;
    }

    public void setBreweryRating(int breweryRating) {
        this.breweryRating = breweryRating;
    }

    public String getBreweryReview() {
        return breweryReview;
    }

    public void setBreweryReview(String breweryReview) {
        this.breweryReview = breweryReview;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }



    // Methods
    @Override
    public String toString() {
        return "BreweryReview{" +
                "breweryReviewId=" + breweryReviewId +
                ", breweryId=" + breweryId +
                ", reviewerId=" + reviewerId +
                ", breweryRating=" + breweryRating +
                ", breweryReview='" + breweryReview +
                ", datePosted=" + datePosted +
                '}';
    }
}
