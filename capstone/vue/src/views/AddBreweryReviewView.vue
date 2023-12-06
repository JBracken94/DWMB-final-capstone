<template>
  <div>
  </div>
</template>

<script>
import BreweryReviewService from '../services/BreweryReviewService';

export default {
  data() {
    return {
      breweryReview: {
      }
    };
  },
  methods: {
    addBreweryReview() {
      BreweryReviewService.addBreweryReview(this.breweryReview)
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