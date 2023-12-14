<template>
  <form class="create-beer-form" v-on:submit.prevent="createBeer" v-show="showForm">
    <div class="mb-3">
      <label for="beerName" class="form-label">Beer Name</label>
      <input v-model="newBeer.beerName" type="text" class="form-control" name="beerName" placeholder="Enter beer name" required>
    </div>

    <div class="mb-3">
      <label for="beerType" class="form-label">Beer Type</label>
      <input v-model="newBeer.beerType" type="text" class="form-control" name="beerType" placeholder="Enter beer type" required>
    </div>

    <div class="mb-3">
      <label for="beerDescription" class="form-label">Description</label>
      <textarea v-model="newBeer.description" class="form-control" name="beerDescription" rows="3" required></textarea >
    </div>

    <div class="mb-3">
      <label for="abv" class="form-label">Abv</label>
      <input v-model="newBeer.abv" type="number" class="form-control" step="0.1" name="abv" placeholder="Enter % Abv, example 5.5" required>
    </div>

    <!-- <div class="mb-3">
      <label for="labelImage" class="form-label">Label Image</label>
      <input v-model="newBeer.labelImage" type="text" class="form-control" name="labelImage"
        placeholder="Enter Label Image, example 'yourbeerlabel.jpg'" required>
    </div> -->

    <button type="submit" class="btn btn-primary">Submit New Beer</button>
  </form>
</template>
  
<script>

import BeerService from '../services/BeerService'

export default {
  data() {
    return {
      newBeer: {
        beerId: 0,
        beerName: '',
        beerType: '',
        description: '',
        abv: '',
        labelImage: '',
        breweryId: 0
      },

      currentBrewery: this.brewery.breweryId,

      showForm: true
    }
  },
  props: ['brewery'],
  methods: {
    createBeer() {
      BeerService.createBeer(this.newBeer)
        .then(response => {
          if (response.status == 201) {
            //Notification of successful
            alert('Success!');
            this.$store.dispatch('getBeersByBrewery', this.brewery)
          }
        })
        .catch(error => {
          if (error.response.status === 500) {
            alert('500')
          }
        });
      this.resetForm();
      // Look at setNotification from Lecture
    },
    resetForm() {
      this.newBeer = {
        // beerId: 0,
        // breweryId: this.currentBrewery.breweryId
      };
    }
  },
  updated() {
    this.newBeer.breweryId = this.brewery.breweryId;
  }
}
</script>
  
<style>

</style>