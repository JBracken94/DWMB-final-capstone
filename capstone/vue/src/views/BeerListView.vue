<template>
  <div id="beer-list">
  </div>
</template>

<script>
import BeerService from '../services/BeerService';

export default {
  data() {
    return {
      beers: [] 
    };
  },
  mounted() {
    this.getBeers();
  },
  methods: {
    getBeers() {
      BeerService.getBeers()
        .then(response => {
          this.beers = response.data;
        })
        .catch(error => {
          console.error(error);
        });
    }
  }
};
</script>

<style>
</style>