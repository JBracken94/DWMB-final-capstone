<template>
  <h1>About Brewery</h1>
  <div v-show="1">
    <button > Update my Brewery</button>
    <button> Add Beer</button>
  </div>
  <brewery-details v-bind:brewery="brewery"/>
  
  <!-- Brewery Info Box -->
  <!-- Logo Display, Name, Description -->
  <!-- GOOGLE MAP OF BREWERY LOCATION??? -->
  <!-- OPTIONAL :: BUTTON TOGGLE ADD BREWERY REVIEW -->
  <!-- BEER LIST / BEER CARDS -->
  <!-- <google-map v-bind:address="combinedAddress"/> -->
  <beer-list v-bind:beers="beers"/>
</template>

<script>
import GoogleMap from '../components/GoogleMap.vue';
import BeerService from '../services/BeerService';
import BreweryService from '../services/BreweryService';
import BeerList from '../components/BeerList.vue';
import BreweryDetails from '../components/BreweryDetails.vue';
export default {
  data() {
    return {
      brewery: [],
      beers: []
    }
  },
  // GET CURRENT BREWERY
  // GET BEER LIST FOR BREWERY

  components: {
    GoogleMap,
    BeerList,
    BreweryDetails
  },
  created() {
    BreweryService.getBrewery(this.$route.params.breweryId)
    .then(response => {
      this.brewery = response.data;
    });
    BeerService.getBeersByBrewery(this.$route.params.breweryId)
    .then(response => {
      this.beers = response.data;
    })
  }
}
</script>

<style></style>