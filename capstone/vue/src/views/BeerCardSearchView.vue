<template>
  <h1>Beer Card Search</h1>
  <!-- BUTTONS ON CARDS TO ADD SAVED -->
  <!-- ADD BEER button for ROLE_BREWER (Maybe lives in brewery details) -->
  <!-- Search/Filter Fields -->
  <!-- Container with BeerCards / Beer List -->
  <beer-list v-bind:beers="beers"></beer-list>
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
  methods: { // TODO :: HANDLE ERRORS
    getAllBeers() {
      BeerService.getBeers()
        .then(response => {
          this.beers = response.data;
          this.isLoading = false;
        })
        .catch(error => {
          if (error.status === 500) {
            alert("There was an issue reaching the server. Please try again.")
            this.$router.push({ name: 'beers' });
          }
        });
    },
    created() {
      this.BeerService.getBeers();
    }
  }
}
</script>

<style></style>