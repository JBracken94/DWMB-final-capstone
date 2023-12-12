<template>
  <div class="review-card">
    <h1>Review Card</h1>
    <div>
      <h3>{{ review.beerRating }}</h3>
      <p>{{ review.beerReview }}</p>

    </div>
    <!-- <form @submit="submitReview">
      <div>
        <label for="reviewText">Review:</label>
        <textarea id="reviewText" v-model="beerReview"></textarea>
      </div>
      <div>
        <label for="rating">Rating:</label>

      </div>
      <button type="submit">Submit Review</button>
    </form> -->
  </div>
</template>

<script>

export default {
  props: ['review'],
  data() {
    return {
      newReview: {
        reviewId: 0,
        beerId: 0,
        beerRating: 0,
        beerReview: '',
        datePosted: Date.now
      }
    };
  },
  methods: {
    fetchReviews() {

      // make a request to get the reviews api etc
    },
    resetForm () {
      this.newReview = {
        reviewId: 0,
      }
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