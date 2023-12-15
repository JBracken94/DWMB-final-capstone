<template>
  <h1 class="my-list">My Favorite Beers</h1>
  <!-- BUTTONS ON CARDS TO DELETE SAVED -->
  <!-- List of My Saved Breweries -->
  <!-- What should show if no saved beers? -->
  <beer-list v-bind:beers="this.$store.state.savedBeers" class="my-saved-beers"/>
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
}
</script>

<style>
.my-list {
  padding-top: 20px;
  color: #e79115;
  font-size: 80px;
}
.my-saved-beers {
  color: brown;
  margin-left: 200px;
}
</style>