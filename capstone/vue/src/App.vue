<template>
  <div id="capstone-app">
    
    
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home &nbsp;|&nbsp;</router-link> 
      <router-link v-bind:to="{ name: 'beers' }" v-if="$store.state.token">Beers &nbsp;|&nbsp;</router-link>
      <router-link v-bind:to="{ name: 'breweries' }" v-if="$store.state.token">Breweries &nbsp;|&nbsp;</router-link>
      <router-link v-bind:to="{ name: 'saved' }" v-if="$store.state.token">My D.W.B &nbsp;|&nbsp;</router-link>
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    
    <router-view />
  </div>
</template>

<script>
import BeerCard from './components/BeerCard.vue';

export default {
  data() {
    return {
    };
  },
  components: {
    
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
  background-color: rgb(34, 31, 31); 
  background-size: auto;
  height: 200vh;
 
}
#nav {
  background-color: goldenrod;
  position: fixed;
  width: 100%;
  word-spacing: 20px;
  
}

/* this is remove that whitespace gap and it reflects to all the componetns */
body, html, #app {
  margin: 0;
  padding: 0;
}


</style>