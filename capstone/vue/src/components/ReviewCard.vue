<template>
  <div>
    <h1>Review Card</h1>
    <div v-for="review in reviews" :key="review.id">
      <p>{{ review.text }}</p>
      <p>{{ review.rating }}</p>
    </div>
    <form @submit="submitReview">
      <div>
        <label for="reviewText">Review:</label>
        <textarea id="reviewText" v-model="reviewText"></textarea>
      </div>
      <div>
        <label for="rating">Rating:</label>
         
        <!-- rating compoenet logic -->

      </div>
      <button type="submit">Submit Review</button>
    </form>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      reviews: [],
      reviewText: '',
      rating: '',
    };
  },
  mounted() {
    this.fetchReviews();
  },
  methods: {
    fetchReviews() {

      // make a request to get the reviews api etc
      axios.get('/api/reviews')
        .then(response => {
          this.reviews = response.data;
        })
        .catch(error => {
          console.error('Error fetching reviews:', error);
        });
    },
    submitReview() {
      // so i would need to send a post method request to the server with the reivew stuff detailed informaiton
      // then i would need to review the text and the rating props propeties in the request payload
      // last i would need to figure out how to handle the response from the server
      
// display fields ssomthing prop from review list
    },
  },
};
</script>

<style>
/* make it look sexy X styles */
</style>