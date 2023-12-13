<template>
  <h1>{{ brewery.breweryName }}</h1>
  <div v-show="checkFounder">
    <button @click="showUpdateBrewery = !showUpdateBrewery">{{showUpdateBrewery ? 'Hide Brewery Update Form' : 'Update My Brewery'}}</button>
    <update-brewery-form v-show="showUpdateBrewery" v-bind:brewery="brewery"/>

    <!-- <button @click="showCreateBeer = !showCreateBeer">{{ showCreateBeer ? 'Hide' : 'Add New Beer' }}</button> -->
    <button v-show="!showCreateBeer" @click="showCreateBeer = !showCreateBeer">Add New Beer</button>
    <create-beer-form v-show="showCreateBeer" v-bind:brewery="brewery" />
    <button v-show="showCreateBeer" @click="showCreateBeer = !showCreateBeer">Cancel Add New Beer</button>

  </div>
  
  <!-- Brewery Info Box -->
  <!-- Logo Display, Name, Description -->
  <!-- GOOGLE MAP OF BREWERY LOCATION??? -->
  <!-- OPTIONAL :: BUTTON TOGGLE ADD BREWERY REVIEW -->
  <!-- BEER LIST / BEER CARDS -->
  <brew-map v-bind:brew="brewery" v-bind:address="fixedAddress"/>
  <beer-list v-bind:beers="this.$store.state.beers"/>
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
    this.getBreweryById();
    this.getBeersByBrewery();
    
  },
  methods: {
    getBeersByBrewery() {
      BeerService.getBeersByBrewery(this.$route.params.breweryId)
    .then(response => {
      this.beers = response.data;
      this.$store.commit('SET_BEER_LIST', this.beers);
    })
    .catch(error => {
      console.log(error)
    })
    },
    getBreweryById() {
      BreweryService.getBreweryById(this.$route.params.breweryId)
    .then(response => {
      this.brewery = response.data;
      this.$store.commit('SET_BREWERY', this.brewery);
    });
    }
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

<style>
.brew-details {
  color: white;
}
</style>