<template>
  <div class="home">
    <h1 class="header">Dude, Where's My Brewery?</h1>

    <p>Welcome to the home for Brewers and Beer Lovers</p>
    <div class="new-brew-form">
      <button class="create-brew-button" @click="toggleCreateBreweryForm">{{ this.$store.state.showCreateBreweryForm ? 'Hide Add New Brewery' : 'Add New Brewery' }}</button>
      <create-brewery-form v-show="this.$store.state.showCreateBreweryForm" />
    </div>
    <div>
      <router-link :to="{name: 'breweries'}" ><img src="../assests/images/placeholders/roberta-keiko-kitahara-santana-RfL3l-I1zhc-unsplash-2-1536x639.webp" alt=""> </router-link>
      
      <router-link :to="{name: 'beers'}"> 
        <img src="../assests/images/placeholders/twobeers.jpg" />
      </router-link>
      <!-- <beer-card v-bind:beer="this.$store.state.beer" /> -->
    </div>
    <div>

      <!-- <brewery-card v-bind:brewery="this.$store.state.brewery"/> -->
      <router-link :to="{name: 'beers'}"> 
        <img src="../assests/images/placeholders/beers.jpg" />
      </router-link>
      <router-link :to="{name: 'breweries'}"> 
        <img src="../assests/images/placeholders/bar.jpg" />
      </router-link>

    </div>
    <!-- Button for Brewer Dashboard v-show="user.role = ROLE_BREWER localstorage reference" -->
    <!-- Button for BreweryCardSearch View -->
    <!-- Button for BeerCardSearch View -->
    <!-- Random Brewery Display -->
    <!-- Meet the Brew Boys Page -->

  </div>


  <footer class="meet-the-bois">
    <p class="meet">Meet the Brew Bois!</p>
    <p class="links">
      <a target="_blank" href="https://www.linkedin.com/in/xhelal-mahmuti/">Xhelal Mahmuti</a>
      <a target="_blank" href="https://www.linkedin.com/in/jeffreybracken/">Jeff Bracken</a>
      <a target="_blank" href="https://www.linkedin.com/in/stevenpickeringscp/">Steven Pickering</a>
      <a target="_blank" href="https://www.linkedin.com/in/spencer-meredith/">Spencer Meredith</a> </p>

    </footer>
</template>

<script>
import CreateBreweryForm from '../components/CreateBreweryForm.vue';
import BeerService from '../services/BeerService';
import BreweryService from '../services/BreweryService';
import BeerCard from '../components/BeerCard.vue';
import BreweryCard from '../components/BreweryCard.vue';

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
.links>a{
  text-decoration: underline;
  color:black;
  font-size: 28px;
  margin-right: 50px;
}
.header {
  padding-top: 20px;
}
.meet{
  color: black;
  font-size: 25px;
  margin: auto;
}
h1 {
  text-align: center;
  font-size: 90px;
  color: brown;
  font-family:Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;

}
.meet-the-bois {
  display: inline;
  position: fixed;
  bottom: 0;
  left: 0;
  right: 0;
  z-index: 0;
  background: #e79115;
  background-size: auto;
  height: 100px;
  width: 42vw;
  margin-left: 200px;
  margin-right: 200px;
  margin: auto;

  border-radius: 5px;
}
p {
  text-align: center;
  color: #e79115;
  font-size: 40px;
  
}

img {
  justify-content: center;
  align-items: stretch;
  height: 300px;
  margin: 50px;
}

.create-brew-button {
  color: #e79115;
  display: grid;
  width: 40vh;
  background-color: brown;
  justify-content: center;
  align-items: center;
  border-radius: 10px;
  font-size: 20px;
  margin-right: 20%;
  margin: auto;
}

</style>