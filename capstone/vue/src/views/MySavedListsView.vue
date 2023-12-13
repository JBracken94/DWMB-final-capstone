<template>
  <h1 class="my-list">My Saved Lists</h1>
  <!-- BUTTONS ON CARDS TO DELETE SAVED -->
  <!-- List of My Saved Breweries -->
  <h2 v-show="myBeers.length != 0">Beers</h2>
  <beer-list v-bind:beers="this.$store.state.savedBeers"/>
  <!-- List of My Saved Beers -->
</template>

<script>
import BeerService from '../services/BeerService';
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
    }
  },
  methods: {
    getSavedBeers() {
      BeerService.getSavedBeers()
          .then(response => {
            this.myBeers = response.data;
            this.$store.commit('SET_SAVED_BEERS', this.myBeers);
          });
    }
  },
  created() {
    this.getSavedBeers();
  }
  // GET SAVED BEERS FOR USER
  // GET SAVED BREWERIES FOR USER (MAYBE IMPLEMENT)
}
</script>

<style>
.my-list {
  padding-top: 20px;
  color: gold;
  font-size: 80px;
}
.my-saved-beers {
  color: brown;
}
</style>