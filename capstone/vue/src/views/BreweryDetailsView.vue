<template>
  <div class="brew-info">
    <h1 class="brew-name">{{ brewery.breweryName }}</h1>
    <h4>{{ brewery.city }}, {{ brewery.state }}</h4>
    <p class="brew-details">{{ brewery.aboutUs }}</p>
  </div>
  <div v-show="checkFounder" class="forms">
    <button class="update-brew" @click="this.$store.state.showUpdateBreweryForm = !this.$store.state.showUpdateBreweryForm">
      {{this.$store.state.showUpdateBreweryForm ? 'Hide Update My Brewery' : 'Update My Brewery'}}</button>
    <update-brewery-form class="update-brew" v-show="this.$store.state.showUpdateBreweryForm" v-bind:brewery="brewery"/>

    <!-- <button @click="showCreateBeer = !showCreateBeer">{{ showCreateBeer ? 'Hide' : 'Add New Beer' }}</button> -->
    <button class="create-burr" @click="this.$store.state.showCreateBeerForm = !this.$store.state.showCreateBeerForm">
      {{this.$store.state.showCreateBeerForm ? 'Hide Add a New Beer' : 'Add a New Beer'}}</button>
    <create-beer-form v-show="this.$store.state.showCreateBeerForm" v-bind:brewery="brewery" class="create-burr"/>

  </div>
  
  <!-- Brewery Info Box -->
  <!-- Logo Display, Name, Description -->
  <!-- GOOGLE MAP OF BREWERY LOCATION??? -->
  <!-- OPTIONAL :: BUTTON TOGGLE ADD BREWERY REVIEW -->
  <!-- BEER LIST / BEER CARDS -->
  <div>
    <brew-map v-bind:brew="brewery" v-bind:address="fixedAddress" class="map"/>
    <beer-list v-bind:beers="this.$store.state.beers" class="list"/>

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
.brew-info {
  margin: auto;
  justify-items: center;
}
.brew-name {
  color: #e79115;
  margin: auto;
}
.brew-details {
  color: white;
  width: 50vw;
  margin: auto;
}
.update-brew {
  color: #e79115;
  display: grid;
  width: 20vw;
  background-color: brown;
  justify-content: center;
  align-items: center;
  border-radius: 10px;
  font-size: 20px;
  margin-left: 200px;
  
}
.create-burr {
  color: #e79115;
  display: grid;
  width: 20vw;
  background-color: brown;
  justify-content: center;
  align-items: center;
  border-radius: 10px;
  font-size: 20px;
  margin-left: 200px;
}
.cancel-beer {
  color: #e79115;
  display: grid;
  width: 20vw;
  background-color: brown;
  justify-content: center;
  align-items: center;
  border-radius: 10px;
  font-size: 20px;
}
.update-brewery {
  color: #e79115;
  display: grid;
  width: 20vw;
  background-color: brown;
  justify-content: center;
  align-items: center;
  border-radius: 10px;
  font-size: 20px;
}
.forms {
  margin: auto;
  padding: 10px;
  justify-self: center;
  width: 40vw;

}
.list {
  margin: 50px 200px  50px 200px;
  border: solid black 10px;
  padding: 25px;
}
</style>