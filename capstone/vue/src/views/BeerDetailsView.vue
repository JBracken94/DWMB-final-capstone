<template>
  <div>
    <h2>Beer Details</h2>
    <button @click="showUpdateForm = !showUpdateForm">{{ showUpdateForm ? 'Hide Form' : 'Update Beer'}}</button>
    <update-beer-form v-show="showUpdateForm"/>
    <review-list v-bind:beer="beer"/>
  </div>
</template>

<script>

import BeerService from '../services/BeerService';

import UpdateBeerForm from '../components/UpdateBeerForm.vue';
import ReviewList from '../components/ReviewList.vue';
import BeerReviewService from '../services/BeerReviewService';


export default {
  data() {
    return {
      beer: {},
      reviews: [],
      showUpdateForm: false,
    };
  },

  components: {
    UpdateBeerForm,
    ReviewList
  },

  methods: {
      // this will be the log to submit the information such as beer
      // so note you can access the form data using the (this.beerName and this.beerType and this.beerDescription
      // In theory you make a api request to save the beer details (brewery also possible)
      // then using the Services stuff for example the BeerService.saveBeer(this.beerName, this.beerType, this.beerDescription)

      // take note i need to make 200 or 201 or 404  basically the success and error situation 
  },
  created() {
    BeerService.getBeerById(this.$route.params.id)
    .then(response => {
      this.beer = response.data;
    })
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