<template>
    <h2></h2>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      breweries: [] 
    };
  },
  mounted() {
    this.getBreweries();
  },
  methods: {
    async getBreweries() {
      try {
        const response = await axios.get('/api/breweries'); 
        this.breweries = response.data;
      } catch (error) {
        console.error(error);
      }
    }
  }
};
</script>

<style>
</style>