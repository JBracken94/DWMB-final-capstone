<template>
    <form class="create-beer-form" v-on:submit.prevent="createBeer()">
    <div class="mb-3">
      <label for="beerName" class="form-label">Beer Name</label>
      <input v-model="newBeer.beerName" type="text" class="form-control" id="beerName" placeholder="Enter beer name">
    </div>

    <div class="mb-3">
      <label for="beerType" class="form-label">Beer Type</label>
      <input v-model="newBeer.beerType" type="text" class="form-control" id="beerType" placeholder="Enter beer type">
    </div>

    <div class="mb-3">
      <label for="beerDescription" class="form-label">Description</label>
      <textarea v-model="newBeer.beerDescription" class="form-control" id="beerDescription" rows="3"></textarea>
    </div>

    <div class="mb-3">
      <label for="abv" class="form-label">Abv</label>
      <input v-model="newBeer.abv" type="text" class="form-control" id="abv" placeholder="Enter % Abv, example 5.5">
    </div>

    <div class="mb-3">
      <label for="labelImage" class="form-label">Label Image</label>
      <input v-model="newBeer.labelImage" type="text" class="form-control" id="labelImage" placeholder="Enter Label Image, example 'yourbeerlabel.jpg'">
    </div>

    <button type="submit" class="btn btn-primary">Submit New Beer</button>
  </form>
</template>
  
<script>

    import BeerService from '../services/BeerService'

    export default {
        data() {
            return {
                newBeer: {}
            }
        },
    
        methods: {

            createBeer() {
                BeerService.createBeer(this.newBeer)
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