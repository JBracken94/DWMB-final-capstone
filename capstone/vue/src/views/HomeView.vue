<template>
  <div class="home">
    <h1>Brew-Bois</h1>
    <p>Welcome to the home for brewers and beer lovers</p>
    <img src="https://glacier-design.com/wp-content/uploads/2022/10/Can-you-hydrate-yourself-with-beer-1536x1024.jpg" />
    <!-- Button for Brewer Dashboard v-show="user.role = ROLE_BREWER localstorage reference" -->
    <!-- Button for BreweryCardSearch View -->
    <!-- Button for BeerCardSearch View -->
    <!-- Random Brewery Display -->
    <!-- Meet the Brew Boys Page -->
  </div>
</template>

<script>
import BeerService from '../services/BeerService'
import BreweryService from '../services/BreweryService'

export default {
  // GET RANDOM BREWERY/BEER? BOTH
  // CHECK USER ROLE
  data() {
    return {
      beers: [],
      breweries: [],
    }
  },
  created() {
    BeerService.getBeers()
      .then(response => {
        this.beers = response.data;
      });
    BreweryService.getBreweries()
      .then(response => {
        this.breweries = response.data;
      });
      
  }
}

</script>

<style scoped>
h1 {
  text-align: center;
  font-size: 100px;
  color: brown;
}

p {
  text-align: center;
  color: gold;
  font-size: 50px;
}

img {
  display: flex;
  justify-content: center;
  height: 50vh;
}
</style>