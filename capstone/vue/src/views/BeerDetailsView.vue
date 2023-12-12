<template>
  <div>
    <h2>Beer Details</h2>
    {{ beer.beerName }}
    <button v-show="isFounder" @click="showUpdateForm = !showUpdateForm">{{ showUpdateForm ? 'Hide Form' : 'Update Beer'}}</button>
    <update-beer-form v-show="showUpdateForm"/>
    <review-list v-bind:beer="beer" v-bind:reviews="reviews"/>
  </div>
</template>

<script>

import BeerService from '../services/BeerService';
import UpdateBeerForm from '../components/UpdateBeerForm.vue';
import ReviewList from '../components/ReviewList.vue';
import BeerReviewService from '../services/BeerReviewService';
import BreweryService from '../services/BreweryService';


export default {
  data() {
    return {
      beer: {},
      reviews: [],
      myBrewery: {
      },
      showUpdateForm: false,
      isFounder: false,
    };
  },

  components: {
    UpdateBeerForm,
    ReviewList
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
      BreweryService.getBreweryById(this.beer.breweryId)
    .then(response => {
      this.myBrewery = response.data;
    });
    });
    BeerReviewService.getReviewsByBeerId(this.$route.params.id)
    .then(response => {
      this.reviews = response.data;
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
.form-label {
  font-weight: bold;
}
.form-control {
  margin-bottom: 10px;
}
</style>