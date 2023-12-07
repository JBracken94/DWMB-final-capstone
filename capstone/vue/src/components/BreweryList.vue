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

export default {
  data() {
    return {
      breweries: [],
    };
  },
}
</script>