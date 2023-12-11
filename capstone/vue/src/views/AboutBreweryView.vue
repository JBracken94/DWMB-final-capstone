<template>
  <h1>Brewery Details</h1>
  <div v-show="1">
    <button>Update my Brewery</button>
    <update-brewery-form />
    <button>Add Beer</button>
    <create-beer-form />
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
import LocationService from '../services/LocationService';

import UpdateBreweryForm from '../components/UpdateBreweryForm.vue';
import CreateBeerForm from '../components/CreateBeerForm.vue';

export default {
  data() {
    return {
      brewery: [],
      beers: [],
      isFounder: false,
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
    BreweryService.getBrewery(this.$route.params.breweryId)
    .then(response => {
      this.brewery = response.data;
    });
    BeerService.getBeersByBrewery(this.$route.params.breweryId)
    .then(response => {
      this.beers = response.data;
    });
    // LocationService.getLocation(`${this.address}` + '&key=AIzaSyAWksYN7JVApW1qfftkveDLOTpnQQfdol8')
    // .then(response => {
    //   if (response.data.results.length > 0) {
    //     this.resp = response.data;
    //     this.longitude = response.data.results[0].geometry.location.lng;
    //     this.latitude = response.data.results[0].geometry.location.lat;
    //   }
    // })
  },

  computed: {
    fixedAddress() {
      let newAddress = this.brewery.streetAddress + ' ' + this.brewery.city + ' ' + this.brewery.state + ' ' + this.brewery.zipcode;
      return newAddress;
    }
  }
}
</script>

<style></style>