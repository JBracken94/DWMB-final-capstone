<template>
  <div class="home">
    <h1>Brew-Bois</h1>
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
