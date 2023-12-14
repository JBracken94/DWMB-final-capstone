<template>
  <h1 class="brew-name">{{ brewery.breweryName }}</h1>
  <p>{{ brewery.aboutUs }}</p>
  <div v-show="checkFounder">
    <button class="update-brew" @click="this.$store.state.showUpdateBreweryForm = !this.$store.state.showUpdateBreweryForm">
      {{this.$store.state.showUpdateBreweryForm ? 'Hide Update My Brewery' : 'Update My Brewery'}}</button>
    <update-brewery-form class="update-brewery" v-show="this.$store.state.showUpdateBreweryForm" v-bind:brewery="brewery"/>

    <!-- <button @click="showCreateBeer = !showCreateBeer">{{ showCreateBeer ? 'Hide' : 'Add New Beer' }}</button> -->
    <button class="create-burr" @click="this.$store.state.showCreateBeerForm = !this.$store.state.showCreateBeerForm">
      {{this.$store.state.showCreateBeerForm ? 'Hide Add a New Beer' : 'Add a New Beer'}}</button>
    <create-beer-form v-show="this.$store.state.showCreateBeerForm" v-bind:brewery="brewery" />

  </div>
  
  <!-- Brewery Info Box -->
  <!-- Logo Display, Name, Description -->
  <!-- GOOGLE MAP OF BREWERY LOCATION??? -->
  <!-- OPTIONAL :: BUTTON TOGGLE ADD BREWERY REVIEW -->
  <!-- BEER LIST / BEER CARDS -->
  <div>
    <brew-map v-bind:brew="brewery" v-bind:address="fixedAddress"/>
    <beer-list v-bind:beers="this.$store.state.beers"/>

  </div>
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
      brewery: {},
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
  },
  updated() {
    this.getBeersByBrewery();
  }
}
</script>

<style>
.brew-name {
  color: goldenrod;
}
.brew-details {
  color: white;
}
.update-brew {
  color: goldenrod;
  display: grid;
  width: 40vh;
  background-color: brown;
  justify-content: center;
  align-items: center;
  border-radius: 10px;
  font-size: 20px;
  margin-left: 750px;
  
}
.create-burr {
  color: goldenrod;
  display: grid;
  width: 40vh;
  background-color: brown;
  justify-content: center;
  align-items: center;
  border-radius: 10px;
  font-size: 20px;
  margin-left: 750px;
}
.cancel-beer {
  color: goldenrod;
  display: grid;
  width: 40vh;
  background-color: brown;
  justify-content: center;
  align-items: center;
  border-radius: 10px;
  font-size: 20px;
  margin-left: 750px;
}
.update-brewery {
  color: goldenrod;
  display: grid;
  width: 40vh;
  background-color: brown;
  justify-content: center;
  align-items: center;
  border-radius: 10px;
  font-size: 20px;
  margin-left: 750px;
}
</style>