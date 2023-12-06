<template>
  <div class="beer-details-container">
    <h2>{{ beer.beerName }}</h2>
    <p>Brewery:ID {{ beer.breweryId  }}</p>
    <p>BeerType {{ beer.beerType }}</p>
    <p>Abv {{ beer.abv }}</p>
    <img :src="beer.labelImage" alt="beer label image">
    <p>Description {{ beer.description }}</p>


   
  </div>
</template>

<script>
export default {
    props: {
      beer: {
        type: Object,
        required: true
        
      }
    }

}
</script>

<style>

</style>