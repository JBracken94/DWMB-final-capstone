<template>
  <h2 class="bcs">Brewery Card Search</h2>
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
      this.$store.commit('SET_BREWERIES', this.breweries);
      this.$store.dispatch('getBreweries');
    })
  }
}
</script>

<style>

.bcs {
  background-image: url('../assests\images/placeholders/breweryBackground.jpg');
  background-color: #cccccc;
  background-size: cover;
  background-position: center;
  height: 100 vh;
  font-size: 80px;
  color: goldenrod;
  padding-top: 3rem;
}


</style>