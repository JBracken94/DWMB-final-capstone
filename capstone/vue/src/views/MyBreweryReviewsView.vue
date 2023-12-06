<template>
    <div class="my-brewery-reviews">
      <h2>My Brewery Reviews</h2>
      <ul>
        <li v-for="review in breweryReviews" :key="review.id">
          <h3>{{ review.breweryName }}</h3>
          <p>Rating: {{ review.rating }}</p>
          <p>Comments: {{ review.comments }}</p>
        </li>
      </ul>
    </div>
  </template>
  
  <script>
  import BreweryReviewService from '../services/BreweryReviewService';
  
  export default {
    data() {
      return {
        breweryReviews: [] 
      };
    },
    mounted() {
      this.getMyBreweryReviews();
    },
    methods: {
      getMyBreweryReviews() {
        BreweryReviewService.getMyBreweryReviews()
          .then(response => {
            this.breweryReviews = response.data;
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