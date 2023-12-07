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
</template>

<script>
import { ref } from "vue";
import { getMySavedBeers } from "../services/BeerService";import BeerList from "../components/BeerList.vue";

export default {
  components: {
    BeerList,
  },
  setup() {
    const showBeerList = ref(false);
    const allBeers = ref([]);

    const toggleBeerList = () => {
      showBeerList.value = !showBeerList.value;
      if (showBeerList.value) {
        fetchSavedBeers();
      }
    };
    

    const fetchSavedBeers = async () => {
      try {
        const beers = await getMySavedBeers();
        allBeers.value = beers;
      } catch (error) {
        console.error(error);
      }
    };

    return {
      showBeerList,
      allBeers,
      toggleBeerList,
    };
  },
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