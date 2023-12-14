<template>
  <div class="review-card">
    <div>
      <div>
        <h3 class="rev-rating">{{ review.beerRating }}</h3>
        <star-rating 
        :rating="review.beerRating"
        :increment=".5"
        :read-only="true"

        active-color="#daa520" border-color="#a52a2a"
                        :padding="1"
                        :glow="3" glow-color="#FFC0CB" 
                        :animate="true" :border-width="2"
                        :show-rating="false" />
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
import StarRating from 'vue-star-rating';

export default {
  props: ['review'],
  components: {
    StarRating
   
  },
  data() {
    return {
    };
  },
  methods: {
  },
};
</script>

<style>
/* make it look sexy X styles */
.review-card {
    display: grid;
    width: 18rem;
    justify-content: center;
    align-items: center;
    min-height: 50vh;
    border-color: #a52a2a;    border-radius: 30px;
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