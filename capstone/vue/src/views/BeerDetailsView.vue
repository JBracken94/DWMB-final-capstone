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
    <button @click="showReviewForm = !showReviewForm"> Review this Beer </button>
    <update-beer-form v-show="showUpdateForm"/>
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
      showUpdateForm: true,
      showReviewForm: false,
      isFounder: false,
    };
  },

  components: {
    UpdateBeerForm,
    ReviewList,
    CreateReview
  },
      // this will be the log to submit the information such as beer
      // so note you can access the form data using the (this.beerName and this.beerType and this.beerDescription
      // In theory you make a api request to save the beer details (brewery also possible)
      // then using the Services stuff for example the BeerService.saveBeer(this.beerName, this.beerType, this.beerDescription)

      // take note i need to make 200 or 201 or 404  basically the success and error situation 

  created() {
    BeerService.getBeerById(this.$route.params.id)
    .then(response => {
      this.beer = response.data;
      this.$store.commit('SET_BEER', this.beer);
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