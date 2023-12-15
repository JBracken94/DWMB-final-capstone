<template>
  <h1 class="bca">Beers</h1>
  <!-- BUTTONS ON CARDS TO ADD SAVED -->
  <!-- ADD BEER button for ROLE_BREWER (Maybe lives in brewery details) -->
  <!-- Search/Filter Fields -->
  <!-- Container with BeerCards / Beer List -->
  <beer-list v-bind:beers="this.$store.state.beers" class="beer-list"/>
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
        this.$store.commit('SET_BEER_LIST', this.beers);
        this.isLoading = false;
      });
  }
}
</script>

<style scoped>
.bca {
  padding-top: 20px;
  
  
}
.beer-list {
  margin: left 200px;
}
* {
  margin-left: 200px;
}

h1 {
  color: #e79115;
  font-size: 100px;
  
}
</style>