<template>
  <div class="home">
    <h1 class="header">Dude, Where's My Brewery?</h1>

    <p>Welcome to the home for Brewers and Beer Lovers</p>
    <div>
      <button class="create-brew-button" @click="toggleCreateBreweryForm">{{ this.$store.state.showCreateBreweryForm ? 'Hide' : 'Add New Brewery' }}</button>
      <create-brewery-form v-show="this.$store.state.showCreateBreweryForm" />
    </div>
    <div>
      <img src="../assests/images/placeholders/roberta-keiko-kitahara-santana-RfL3l-I1zhc-unsplash-2-1536x639.webp" />
      <img src="../assests/images/placeholders/twobeers.jpg" />
      <!-- <beer-card v-bind:beer="this.$store.state.beer" /> -->

    </div>
    <div>

      <!-- <brewery-card v-bind:brewery="this.$store.state.brewery"/> -->
      <img src="../assests/images/placeholders/twobeers.jpg" />
      <img src="../assests/images/placeholders/roberta-keiko-kitahara-santana-RfL3l-I1zhc-unsplash-2-1536x639.webp" />

    </div>
    <!-- Button for Brewer Dashboard v-show="user.role = ROLE_BREWER localstorage reference" -->
    <!-- Button for BreweryCardSearch View -->
    <!-- Button for BeerCardSearch View -->
    <!-- Random Brewery Display -->
    <!-- Meet the Brew Boys Page -->

  </div>


  <footer class="meet-the-bois">Meet the Brew Bois!
    <p>Xhelal Mahmuti | Jeff Bracken | Steven Pickering | Spencer Meredith</p>

  </footer>
</template>

<script>
import CreateBreweryForm from '../components/CreateBreweryForm.vue';
import BeerService from '../services/BeerService';
import BreweryService from '../services/BreweryService';
import BeerCard from '../components/BeerCard.vue';
import BreweryCard from '../components/BreweryCard.vue';

// let user = JSON.parse(window.localStorage.getItem('user')); // reads logged in user info from local storage (parse as JSON)
// let userId = user.id; // reads user id
// let roles = user.authorities; // gets authorities or roles array
// function checkRole(expected) { // check user role against passed role value
//   let allowed = false;
//   roles.forEach(auth => {
//     if (auth.name === expected) {
//       allowed = true;
//     }
//   })
//   return allowed;
// }
// console.log(checkRole('ROLE_ADMIN'));

// console
// console.log(roles);
// console.log(user);
// console.log(userId);

export default {
  components: { CreateBreweryForm, BeerCard, BreweryCard },
  // GET RANDOM BREWERY/BEER? BOTH

  // CURRENTLY LOADS ALL BREWERIES AND BEERS TO HOME VIEW
  // PROBABLY NOT WHAT WE WANT
  // PULL ONE RANDOM OF EACH???
  data() {
    return {
      beers: [],
      breweries: [],
      isBrewer: false,
      randomBrewery: {},
      randomBeer: {}
    }
  },

  methods: {
    toggleCreateBreweryForm() {
      this.$store.commit('FLIP_CREATE_BREWERY_FORM');
    },
    getRandomBrewery() {
      BreweryService.getRandomBrewery()
      .then(response => {
        const currBrewery = response.data;
        this.randomBrewery = currBrewery;
        this.$store.commit('SET_BREWERY', currBrewery);
      })
    },
    getRandomBeer() {
      BeerService.getRandomBeer()
      .then(response => {
        const currBeer = response.data.
        this.randomBeer = currBeer;
        this.$store.commit('SET_BEER', currBeer);
      })
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
      this.getRandomBeer;
      this.getRandomBrewery;

    // this.isBrewer = checkRole('ROLE_BREWER');
  }
}

</script>

<style scoped>
.home {
  margin-left: 150px;
}
.header {
  padding-top: 20px;
}

h1 {
  text-align: center;
  font-size: 100px;
  color: brown;

}

p {
  text-align: center;
  color: goldenrod;
  font-size: 50px;
}

img {
  margin-left: 30px;
  justify-content: center;
  align-items: stretch;
  height: 300px;
}

.create-brew-button {
  color: goldenrod;
  display: grid;
  width: 40vh;
  background-color: brown;
  justify-content: center;
  align-items: center;
  border-radius: 10px;
  font-size: 20px;
  margin-right: 20%;
}

.meet-the-bois {
  font-size: 50px;
  color: red;
}</style>