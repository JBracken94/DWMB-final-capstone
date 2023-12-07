<template>
  <div class="beer-list-container">
    <router-link
      v-for="beer in allBeers"
      :key="beer.beerId"
      :to="{ name: 'beer-details', params: { id: beer.beerId } }"
    >
      <div class="beer-item">
        <h3>{{ beer.beerName }}</h3>
        <p>Brewery:ID {{ beer.breweryId }}</p>
        <p>BeerType {{ beer.beerType }}</p>
        <p>Abv {{ beer.abv }}</p>
        <img :src="beer.labelImage" alt="beer label image" />
        <p>Description {{ beer.description }}</p>
      </div>
    </router-link>
  </div>
</template>

<script>
import BeerDetails from "./BeerDetails.vue";

export default {
  components: {
    BeerDetails,
  },
  data() {
    return {
      allBeers: [
        {
          beerId: 3,
          beerName: "Brew Bois Lager",
          breweryId: 2,
          beerType: "Lager",
          abv: 5.2,
          labelImage: "path/to/labelImage",
          description: "Beer description",
        },
        {
             beerId: 4,
             beerName: "Slurp Juice",
             breweryId: 3,
             beerType: "Sour",
             abv: 9.9,
             labelImage: "path/to/labelImage",
             description: "1 Victory Royale...",
           },
      ],
    };
  },
};
</script>

<style>
/* .beer-list-container {
}
.beer-item {
} */
</style>