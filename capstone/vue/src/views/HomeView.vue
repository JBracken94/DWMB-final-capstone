<template>
  <div class="home">
    <h1 class="header">Dude Where's my Brewery!!</h1>

    <p>Welcome to the home for Brewers and Beer lovers</p>
    <img src="https://glacier-design.com/wp-content/uploads/2022/10/Can-you-hydrate-yourself-with-beer-1536x1024.jpg" />
    <img src="../assests/images/placeholders/twobeers.jpg" />
    <!-- Button for Brewer Dashboard v-show="user.role = ROLE_BREWER localstorage reference" -->
    <!-- Button for BreweryCardSearch View -->
    <!-- Button for BeerCardSearch View -->
    <!-- Random Brewery Display -->
    <!-- Meet the Brew Boys Page -->
    
  </div>

  <button class="create-brew-button">Create Brewery</button>
  <create-brewery-form/>
  <footer class="meet-the-bois">Brought to you by</footer>
  <p>Xhelal Mahmuti | Jeff Bracken | Steven Pickering | Spencer Meredith</p>
</template>

<script>
import CreateBreweryForm from '../components/CreateBreweryForm.vue'
import BeerService from '../services/BeerService'
import BreweryService from '../services/BreweryService'
import BeerList from '../components/BeerList.vue'

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
  components: { CreateBreweryForm },
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
      // this.isBrewer = checkRole('ROLE_BREWER');
  }
}

</script>

<style scoped>
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
  height: 50vh;
}
.create-brew-button {
  color: goldenrod;
    display: grid;
    width: 40vh;
    background-color:brown;
    justify-content: center;
    align-items: center;
    border-radius: 10px;
    font-size: 20px;
    margin-right: 20%;
}
.meet-the-bois {
  font-size: 50px;
  color: red;
}
</style>