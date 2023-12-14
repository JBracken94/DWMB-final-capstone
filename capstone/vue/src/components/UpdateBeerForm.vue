<template>
  <form class="update-beer-form" v-on:submit.prevent="updateBeer" v-show="showUpdateBeer">
    <div class="mb-3">
      <label for="beerName" class="form-label">Beer Name</label>
      <input v-model="updatedBeer.beerName" type="text" class="form-control" id="beerName" placeholder="Update beer name" required>
    </div>

    <div class="mb-3">
      <label for="beerType" class="form-label">Beer Type</label>
      <input v-model="updatedBeer.beerType" type="text" class="form-control" id="beerType" placeholder="Update beer type" required>
    </div>

    <div class="mb-3">
      <label for="beerDescription" class="form-label">Description</label>
      <textarea v-model="updatedBeer.description" class="form-control" id="beerDescription" rows="6"></textarea>
    </div>

    <div class="mb-3">
      <label for="abv" class="form-label">ABV</label>
      <input v-model="updatedBeer.abv" type="text" class="form-control" id="abv" placeholder="Update % ABV, example 5.5" required>
    </div>
<!-- 
    <div class="mb-3">
      <label for="labelImage" class="form-label">Label Image</label>
      <input v-model="updatedBeer.labelImage" type="text" class="form-control" id="labelImage"
        placeholder="Update Label Image, example 'yourbeerlabel.jpg'">
    </div> --> 
    <!-- disregard label image unless image server can be set up
     -->

    <button type="submit" class="btn btn-primary">Submit Changes</button>
  </form>
</template>
  
<script>

import BeerService from '../services/BeerService'

export default {
  data() {
    return {
      updatedBeer: {},
      showUpdateBeer: false
    }
  },

  methods: {

    updateBeer() {
      BeerService.updateBeer(this.updatedBeer)
        .then(response => {
          if (response.status == 200) {
            //Notification of successful
            alert('you did it')
            console.log(response.status)
            this.getBeer;
          }
        })
        .catch(error => {
          if (error.response.status == 500) {
            alert('500')
          } else {
            console.log(error);
          }
        })
      // Look at setNotification from Lecture
    },
    getBeer() {
      BeerService.getBeerById(this.$route.params.id)
      .then(response => {
        const currentBeer = response.data;
        this.updatedBeer = currentBeer;
        this.$store.commit('SET_BEER', currentBeer);
      })      
    }
  },
  created() {
    this.getBeer();
  }
}
</script>
  
<style>

</style>