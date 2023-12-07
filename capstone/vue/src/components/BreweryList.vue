<template>
  <div>
    <h1>Breweries</h1>
    <ul>
      <li v-for="brewery in breweries" :key="brewery.id">
        {{ brewery.name }}
      </li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      breweries: [],
    };
  },
  async created() {
    try {
      const response = await axios.get('http://localhost:9000/breweries');
      this.breweries = response.data;
    } catch (error) {
      console.error(error);
    }
  },
};
</script>