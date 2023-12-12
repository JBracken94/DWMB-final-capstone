<template>
  <h1 class="bca">Beer Card Search</h1>
  <!-- BUTTONS ON CARDS TO ADD SAVED -->
  <!-- ADD BEER button for ROLE_BREWER (Maybe lives in brewery details) -->
  <!-- Search/Filter Fields -->
  <!-- Container with BeerCards / Beer List -->
  <beer-list v-bind:beers="beers"/>
</template>

<script>
import BeerService from '../services/BeerService';
import BeerList from '../components/BeerList.vue';
export default {
  data() {
    return {
      beers: [],
      isLoading: true,
    }
  },
  components: {
    BeerList
  },
  // GET ALL BEERS
  // FILTER BEERS
  // CHECK USER ROLE
  methods: {
  },
  created() {
    BeerService.getBeers()
      .then(response => {
        this.beers = response.data;
        this.isLoading = false;
      });
  }
}
</script>

<style scoped>


h1 {
  color: gold;
  font-size: 100px;
  
}
</style>