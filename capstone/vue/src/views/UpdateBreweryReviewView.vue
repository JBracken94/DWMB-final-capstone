<template>
  <div>
    <h2>lj</h2>
  </div>
</template>

<script>
import BreweryReviewService from '../services/BreweryReviewService';

export default {
  data() {
    return {
      breweryReview: {
        // props for the brewery review
      }
    };
  },
  methods: {
    updateBreweryReview() {
      BreweryReviewService.updateBreweryReview(this.breweryReview)
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