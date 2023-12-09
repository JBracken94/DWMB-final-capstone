<template>
  <h1>My Saved Lists</h1>
  <!-- BUTTONS ON CARDS TO DELETE SAVED -->
  <h2 v-show="myBreweries.length != 0">Breweries</h2>
  <brewery-list v-bind:breweries="myBreweries"/>
  <!-- List of My Saved Breweries -->
  <h2 v-show="myBeers.length != 0">Beers</h2>
  <beer-list v-bind:beers="myBeers"/>
  <!-- List of My Saved Beers -->
</template>

<script>
import BeerService from '../services/BeerService';
import BreweryService from '../services/BreweryService';
import BeerList from '../components/BeerList.vue';
import BreweryList from '../components/BreweryList.vue';

export default {
  components: {
    BeerList,
    BreweryList
  },
  data() {
    return {
      myBeers: [],
      myBreweries: []
    }
  },
  created() {
    BeerService.getSavedBeers()
    .then(response => {
      this.myBeers = response.data;
    });
    BreweryService.getMySavedBreweries()
    .then(response => {
      this.myBreweries = response.data;
    })
  }
  // GET SAVED BEERS FOR USER
  // GET SAVED BREWERIES FOR USER (MAYBE IMPLEMENT)
}
</script>

<style></style>