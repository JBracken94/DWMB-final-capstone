<template>
  <h1>Brewery Details</h1>
  <div v-show="checkFounder">
    <button @click="showUpdateBrewery = !showUpdateBrewery">{{showUpdateBrewery ? 'Hide Brewery Update Form' : 'Update My Brewery'}}</button>
    <update-brewery-form v-show="showUpdateBrewery"/>
    <button @click="showCreateBeer = !showCreateBeer">{{ showCreateBeer ? 'Hide' : 'Add New Beer' }}</button>
    <create-beer-form 
    v-show="showCreateBeer"
    v-bind:brewery="brewery"/>
  </div>
  
  <!-- Brewery Info Box -->
  <!-- Logo Display, Name, Description -->
  <!-- GOOGLE MAP OF BREWERY LOCATION??? -->
  <!-- OPTIONAL :: BUTTON TOGGLE ADD BREWERY REVIEW -->
  <!-- BEER LIST / BEER CARDS -->
  <brew-map v-bind:brew="brewery" v-bind:address="fixedAddress"/>
  <beer-list v-bind:beers="beers"/>
</template>

<script>

import BrewMap from '../components/BrewMap.vue';
import BeerService from '../services/BeerService';
import BreweryService from '../services/BreweryService';
import BeerList from '../components/BeerList.vue';

import UpdateBreweryForm from '../components/UpdateBreweryForm.vue';
import CreateBeerForm from '../components/CreateBeerForm.vue';

export default {
  data() {
    return {
      brewery: [],
      beers: [],
      isFounder: false,
      showUpdateBrewery: false,
      showCreateBeer: false,
    }
  },
  // GET CURRENT BREWERY
  // GET BEER LIST FOR BREWERY

  components: {
    BrewMap,
    BeerList,
    UpdateBreweryForm,
    CreateBeerForm
  },

  created() {
    BreweryService.getBreweryById(this.$route.params.breweryId)
    .then(response => {
      this.brewery = response.data;
    });
    BeerService.getBeersByBrewery(this.$route.params.breweryId)
    .then(response => {
      this.beers = response.data;
    });
  },

  computed: {
    fixedAddress() {
      let newAddress = this.brewery.streetAddress + ' ' + this.brewery.city + ' ' + this.brewery.state + ' ' + this.brewery.zipcode;
      return newAddress;
    },
    checkFounder() {
      let user = JSON.parse(window.localStorage.getItem('user'));
      return user.id == this.brewery.founderId;
    }
  }
}
</script>

<style></style>