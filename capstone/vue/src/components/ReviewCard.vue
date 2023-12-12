<template>
  <div class="review-card">
    <div>
      <div>
        <h3 class="rev-rating">{{ review.beerRating }}</h3>
      </div>
      <div class="rev-text">
        <p>{{ review.beerReview }}</p>
      </div>

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
.rev-card {
    display: flex;
    width: 18rem;
    justify-content: center;
    align-items: center;
    min-height: 50vh;
    border-color: brown;
    border-radius: 30px;
    background-image: url('../assests\images/placeholders/review1.jpg');
    background-color:black;
    background-size: cover;
    background-position: center;
    height: 50vh;
    
    margin: auto;
    margin-bottom: 30px;
    
  }
  .rev-text {
    margin-top: 10px;
    font-size: 1.5rem;
    color:black;

  }
  .rev-rating{
    font-size: 3rem;
    color:red;
  }
</style>