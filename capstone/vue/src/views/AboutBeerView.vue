<template>
  <h1>AboutBeer</h1>
  <h2>beer details go here</h2>
  <!-- BEER LOGO/INFO -->
  <!-- NAME, TYPE, ABV, AVG RATING,  -->
  <!-- DESCRIPTION -->
  <!-- BUTTON TOGGLE ADD BEER REVIEW -->
  <!-- REVIEW LIST DISPLAYED AS CARDS -->
  <review-list v-bind:reviews="reviews"/>
  
</template>

<script>
import ReviewList from "../components/ReviewList.vue";

export default {
  components: {
    ReviewList
  },

  data() {
    return {
      reviews: [],
    };
  },

}
  // GET CURRENT BEER
  // GET REVIEWS BY BEER
</script>

<style></style>