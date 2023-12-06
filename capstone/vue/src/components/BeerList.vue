
<template>
  <div class="beer-list-container">
    <router-link v-for="beer in beers" :key="beer.id" :to="{ name: 'beer-details', params: { id: beer.id }}">
      <div class="beer-item">
        <h3>{{ beer.beerName }}</h3>
        <p>Brewery:ID {{ beer.breweryId }}</p>
        <p>BeerType {{ beer.beerType }}</p>
        <p>Abv {{ beer.abv }}</p>
        <img :src="beer.labelImage" alt="beer label image">
        <p>Description {{ beer.description }}</p>
      </div>
    </router-link>
  </div>
</template>

<script>
import BeerDetails from './BeerDetails.vue';


export default {
  components: {
    BeerDetails
  },
  
  data() {
    return {
      beers: [] 
    };
  }
}
</script>

<style>
/* .beer-list-container {
}
.beer-item {
} */
</style>