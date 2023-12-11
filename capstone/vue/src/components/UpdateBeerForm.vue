<template>
    <form class="update-beer-form" v-on:submit.prevent="updateBeer(beerToUpdate)">
    <div class="mb-3">
      <label for="beerName" class="form-label">Beer Name</label>
      <input v-model="updatedBeer.beerName" type="text" class="form-control" id="beerName" placeholder="Update beer name">
    </div>

    <div class="mb-3">
      <label for="beerType" class="form-label">Beer Type</label>
      <input v-model="updatedBeer.beerType" type="text" class="form-control" id="beerType" placeholder="Update beer type">
    </div>

    <div class="mb-3">
      <label for="beerDescription" class="form-label">Description</label>
      <textarea v-model="updatedBeer.beerDescription" class="form-control" id="beerDescription" rows="3"></textarea>
    </div>

    <div class="mb-3">
      <label for="abv" class="form-label">Abv</label>
      <input v-model="updatedBeer.abv" type="text" class="form-control" id="abv" placeholder="Update % Abv, example 5.5">
    </div>

    <div class="mb-3">
      <label for="labelImage" class="form-label">Label Image</label>
      <input v-model="updatedBeer.labelImage" type="text" class="form-control" id="labelImage" placeholder="Update Label Image, example 'yourbeerlabel.jpg'">
    </div>

    <button type="submit" class="btn btn-primary">Submit Changes</button>
  </form>
</template>
  
<script>

    import BeerService from '../services/BeerService'

    export default {
        data() {
            return {
                updatedBeer: {}
            }
        },
    
        methods: {

            updateBeer(beerToUpdate) {
                BeerService.updateBeer(this.updatedBeer)
                .then (response => {
                    if (response.status == 200) {
                        //Notification of successful
                        alert('Success!');
                    } else if (response.status == 500) {
                        //Server error notification
                        alert('Doh!');
                    } else {
                        //Some other error
                        alert(response.status);
                    }
                });
                // Look at setNotification from Lecture
            }
        }
    }
</script>
  
<style>
  
</style>