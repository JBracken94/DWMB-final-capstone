<template>
  <div class="beer-list-container">
    <BeerCard v-for="beer in allBeers" v-bind:key="beer.beerId" v-bind:beer="beer"/>
  </div>
</template>

<script>
import BeerDetails from "./BeerDetails.vue";
import BeerCard from "./BeerCard.vue";
import BeerService from '../services/BeerService';

export default {
  components: {
    BeerDetails,
    BeerCard,
  },
  data() {
    return {
      allBeers: [],
    };
  },
  methods: {
    getBeers() {
      BeerService.getBeers()
      .then(response => {
          this.allBeers = response.data;
      })
      .catch(error =>{
          console.error(error);
      });
    },
  },
  created (){
    this.getBeers();
  }
};
</script>

<style>
/* .beer-list-container {
}
.beer-item {
} */
</style>