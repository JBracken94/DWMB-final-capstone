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

let user = JSON.parse(window.localStorage.getItem('user'));
let userId = user.id;
let roles = user.authorities;
function checkRole(expected) {
  let allowed = false;
  roles.forEach(auth => {
    if (auth.name === expected) {
      allowed = true;
    }
  })
  return allowed;
}
console.log(checkRole('ROLE_ADMIN'));

console
console.log(roles);
console.log(user);
console.log(userId);

export default {
  // GET RANDOM BREWERY/BEER? BOTH

  // CURRENTLY LOADS ALL BREWERIES AND BEERS TO HOME VIEW
  // PROBABLY NOT WHAT WE WANT
  // PULL ONE RANDOM OF EACH???
  data() {
    return {
      beers: [],
      breweries: [],
      isBrewer: false,
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
      this.isBrewer = checkRole('ROLE_BREWER');
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