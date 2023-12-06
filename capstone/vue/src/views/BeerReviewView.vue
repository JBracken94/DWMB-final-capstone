<template>
    <div class="beer-review">
      <h2>Beer Review</h2>
      <p>Reviewer's Name: {{ reviewerName }}</p>
      <p>Rating: {{ rating }}</p>
      <p>Comments: {{ comments }}</p>
    </div>
  </template>
  
  <script>
  import ReviewService from '../services/ReviewService';
  
  export default {
    data() {
      return {
        reviewerName: '', 
        rating: '', 
        comments: '' 
      };
    },
    mounted() {
      this.getBeerReview();
    },
    methods: {
      getBeerReview() {
        ReviewService.getBeersReviewById(reviewId)
          .then(response => {
            this.reviewerName = response.data.reviewerName;
            this.rating = response.data.rating;
            this.comments = response.data.comments;
          })
          .catch(error => {
            console.error(error);
          });
      }
    }
  };
  </script>
  
  <style>
  </style>