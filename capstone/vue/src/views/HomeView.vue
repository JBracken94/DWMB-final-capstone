<template>
  <div class="home">
    <h1>Brew-Bois</h1>
    <p>Welcome to the home for brewers and beer lovers</p>
    <img
      src="https://glacier-design.com/wp-content/uploads/2022/10/Can-you-hydrate-yourself-with-beer-1536x1024.jpg"
    />
    <button @click="toggleBeerList">Toggle Beer List</button>
    <beer-list v-if="showBeerList" :beers="allBeers" />
  </div>
  <div>
    <BeerList :beer="allBeers" />
  </div>
</template>

<script>
import { ref } from "vue";
import BeerList from "../components/BeerList.vue";


export default {
  components: {
    BeerList,
  },
  getMySavedBeers() {
    return {
      allBeers: [
      {
             beerId: 3,
             beerName: "Brew Bois Lager",
             breweryId: 2,
             beerType: "Lager",
              abv: 5.2,
             labelImage: "bbl.jpg",
             description: "Best beer in town!",
           },
           {
             beerId: 4,
             beerName: "Slurp Juice",
             breweryId: 3,
             beerType: "Sour",
             abv: 9.9,
             labelImage: "sj.jpg",
             description: "1 Victory Royale...",
           },
      ],
      showBeerList:false,
    };
  },
     methods: {
      toggleBeerList() {
        this.showBeerList = !this.showBeerList;
      }
  }
};
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
}
</style>