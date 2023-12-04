!<template>
  <div class= "beer-list-container">
    <router-link v-for="beer in beer" v-bind:key="beer.id"
    v-bind:to="{ name: 'beer-details'}">
    </router-link>

  </div>
</template>

<script>
import BeerDetails from '../components/BeerDetails.vue';
export default {
    components: {
        
    }

}
</script>

<style>
.beer-list-container{
    background-color: brown;
}
</style>