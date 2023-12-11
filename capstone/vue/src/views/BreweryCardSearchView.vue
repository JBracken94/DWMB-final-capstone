<template>
  <h1>Brewery Card Search</h1>
  <!-- BUTTONS ON CARDS TO ADD SAVED -->
  <!-- ADD BREWERY BUTTON/FORM for ROLE_BREWER -->
  <!-- Brewery Search Bar/Filter fields -->
  <!-- Container with Brewery Cards / Brewery List-->
  <brewery-list v-bind:breweries="breweries" />
</template>

<script>
import BreweryService from '../services/BreweryService';
import BreweryList from '../components/BreweryList.vue'

export default {
  components: {
    BreweryList
  },
  // GET ALL BREWERIES
  // FILTER BREWERIES
  // CHECK USER ROLE
  data() {
    return {
      breweries: [],
      beers: []
    }
  },
  created() {
    BreweryService.getBreweries()
    .then(response => {
      this.breweries = response.data;
    })
  }
}
</script>

<style>
h1 {
color: gold;
}
</style>