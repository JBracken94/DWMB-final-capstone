<template>
  <div class="home">
    <h1>Brew-Bois</h1>
    <img src="https://glacier-design.com/wp-content/uploads/2022/10/Can-you-hydrate-yourself-with-beer-1536x1024.jpg">
    <p>Welcome to the home for brewers and beer lovers</p>
  </div>
  <div>
    <beer-list />
  </div>
</template>

<script>
import BeerList from '../components/BeerList.vue';
export default {
    components: {
      BeerList
    }
};
</script>

