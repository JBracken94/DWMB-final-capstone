<template>
  <div>
    <button @click="updateBeerReview">Update Beer Review</button>
    <h2>jh</h2>
  </div>
</template>

<script>
import ReviewService from '../services/ReviewService';

export default {
  data() {
    return {
      beerReview: {
        // props for the beer review
      }
    };
  },
  methods: {
    updateBeerReview() {
      ReviewService.updateBeerReview(this.beerReview)
        .then(response => {
        })
        .catch(error => {
        });
    }
  }
};
</script>

<style>
</style>