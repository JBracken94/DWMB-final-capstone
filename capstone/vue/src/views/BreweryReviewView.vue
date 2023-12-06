<template>
  <div>
    <h2>test</h2>
    <button @click="loadBreweryReviews">Load Brewery Reviews</button>
    <ul>
      <li v-for="review in breweryReviews" :key="review.id">{{ review.name }}</li>
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
    this.loadBreweryReviews();
  },
  methods: {
    async loadBreweryReviews() {
      try {
        const response = await BreweryReviewService.getMyBreweryReviews();
                this.breweryReviews = response.data;
      } catch (error) {
        console.error(error);
      }
    }
  }
};
</script>

<style>
</style>