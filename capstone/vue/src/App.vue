<template>
  <div id="capstone-app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout &nbsp;|&nbsp;</router-link>
      <router-link v-bind:to="{ name: 'beers' }" v-if="$store.state.token">Beers &nbsp;|&nbsp;</router-link>
      <router-link v-bind:to="{ name: 'breweries' }" v-if="$store.state.token">Breweries &nbsp;|&nbsp;</router-link>
      <router-link v-bind:to="{ name: 'saved' }" v-if="$store.state.token">My APP NAME</router-link>
    </div>
    <BeerCard :beer="beerData" />
    <router-view />
  </div>
</template>

<script>
import BeerCard from './components/BeerCard.vue';

export default {
  data() {
    return {
      beerData: {
        beerName: 'Beer Name',
        beerType: 'Beer Type',
        abv: 5.0,
        beerId: 1
      }
    };
  },
  components: {
    BeerCard
  }
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>