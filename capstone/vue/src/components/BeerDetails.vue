<template>
  <div>
    <h2>Beer Details</h2>
    <form @submit.prevent="submitForm">
      <div class="mb-3">
        <label for="beerName" class="form-label">Beer Name</label>
        <input v-model="beerName" type="text" class="form-control" id="beerName" placeholder="Enter beer name">
      </div>
      <div class="mb-3">
        <label for="beerType" class="form-label">Beer Type</label>
        <input v-model="beerType" type="text" class="form-control" id="beerType" placeholder="Enter beer type">
      </div>
      <div class="mb-3">
        <label for="beerDescription" class="form-label">Description</label>
        <textarea v-model="beerDescription" class="form-control" id="beerDescription" rows="3"></textarea>
      </div>
      <button type="submit" class="btn btn-primary">Submit</button>
    </form>
  </div>
</template>

<script>
import BeerService from '../services/BeerService';
export default {
  data() {
    return {
      beerName: '',
      beerType: '',
      beerDescription: ''
    };
  },
  methods: {
    submitForm() {
      BeerService.addSavedBeer({
        name:this.beerName,
        type: this.beerType,
        description: this.beerDescription
      })
      .then(response => {
        console.log('Beer details saved successfully:', response);
      })
      .catch(error => {
        console.error('Error saving beer details:', error);
      });
      
      // this will be the log to submit the information such as beer
      // so note you can access the form data using the (this.beerName and this.beerType and this.beerDescription
      // In theory you make a api request to save the beer details (brewery also possible)
      // then using the Services stuff for example the BeerService.saveBeer(this.beerName, this.beerType, this.beerDescription)

      // take note i need to make 200 or 201 or 404  basically the success and error situation 


    }
  }
};
</script>

<style>
.form-label {
  font-weight: bold;
}
.form-control {
  margin-bottom: 10px;
}
</style>