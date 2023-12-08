<template>
  <div class="beer-list-container">
    <beer-card v-for="beer in beers" v-bind:key="beer.beerId" v-bind:beer="beer"/>
  </div>
</template>

<script>
import BeerCard from "./BeerCard.vue";
import BeerService from '../services/BeerService';

export default {
  components: {
    BeerCard,
  },
  props: ['beers'],
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