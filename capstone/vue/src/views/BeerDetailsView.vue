<template>
  <div>
    <h2 class="beer-dets">DWM Reviews</h2>
    <h3 class="beer-nam">
      {{ beer.beerName }}
    </h3>
    <div class="review-button">
    <h4 class="type">
       {{ beer.beerType }}  ::  {{beer.abv}}% 
    </h4>
    
    <button v-show="isFounder" @click="showUpdateForm = !showUpdateForm">{{ showUpdateForm ? 'Hide Form' : 'Update Beer'}}</button>
    <button @click="showUpBeerForm = !showUpBeerForm"> Update this Beer </button>
    <update-beer-form v-show="showUpBeerForm"/>
    <button @click="showReviewForm = !showReviewForm"> Review this Beer </button>
    <create-review v-bind:beer="this.$store.state.beer" v-show="showReviewForm"/>
  </div>
    <review-list v-bind:beer="this.$store.state.beer" v-bind:reviews="this.$store.state.reviews"/>
  </div>
</template>

<script>

import BeerService from '../services/BeerService';
import UpdateBeerForm from '../components/UpdateBeerForm.vue';
import ReviewList from '../components/ReviewList.vue';
import BeerReviewService from '../services/BeerReviewService';
import BreweryService from '../services/BreweryService';
import CreateReview from '../components/CreateReview.vue';


export default {
  data() {
    return {
      beer: {},
      reviews: [],
      myBrewery: {
      },
      showUpBeerForm: false,
      showReviewForm: false,
      isFounder: false,
    };
  },

  components: {
    UpdateBeerForm,
    ReviewList,
    CreateReview
  },
      // take note i need to make 200 or 201 or 404  basically the success and error situation 

  created() {
    BeerService.getBeerById(this.$route.params.id)
    .then(response => {
      this.beer = response.data;
      this.$store.commit('SET_BEER', this.beer);
      // needs to run on beer update
      BreweryService.getBreweryById(this.beer.breweryId)
    .then(response => {
      this.myBrewery = response.data;
      this.$store.commit('SET_BREWERY', this.myBrewery);
    });
    });
    BeerReviewService.getReviewsByBeerId(this.$route.params.id)
    .then(response => {
      this.reviews = response.data;
      this.$store.commit('SET_REVIEWS', this.reviews);
    });
    
  },
  computed: {
    // isFounder() {
    //   let user = JSON.parse(window.localStorage.getItem('user'));
    //   return user.id == this.myBrewery.founderId;
    // },
    brewId() {
      return this.beer.breweryId;
    }
  }
};
</script>

<style>
.beer-dets {
  color: brown;
  padding-top: 60px;
}
.beer-nam {
  color: gold;
}
.type{
  color: goldenrod;
}

.form-label {
  font-weight: bold;
}
.form-control {
  margin-bottom: 10px;
}
.review-button {
    color: gold;
    display: grid;
    justify-content: center;
    align-items: center;
  
    width: 40vh;
    height: 5vh;
    background-color:brown;
    border-radius: 10px;
    font-size: 20px;
  
   
    
}
</style>