<template>
  <div class="my-beer-reviews">
    <h2>My Beer Reviews</h2>
    <ul>
      <li v-for="review in beerReviews" :key="review.id">
        <p>Beer Name: {{ review.beerName }}</p>
        <p>Rating: {{ review.rating }}</p>
        <p>Comments: {{ review.comments }}</p>
      </li>
    </ul>
  </div>
</template>

<script>
import ReviewService from '../services/ReviewService';

export default {
  data() {
    return {
      beerReviews: []
    };
  },
  mounted() {
    this.getMyBeerReviews();
  },
  methods: {
    getMyBeerReviews() {
      ReviewService.getMyBeerReviews()
        .then(response => {
          this.beerReviews = response.data;
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