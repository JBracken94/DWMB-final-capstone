<template>
  <div>
    <h2>Beer Details</h2>
    <button>Update Beer Form</button>
    <update-beer-form />
  </div>
</template>

<script>

import BeerService from '../services/BeerService';

import UpdateBeerForm from '../components/UpdateBeerForm.vue';


export default {
  data() {
    return {
      beerName: '',
      beerType: '',
      beerDescription: ''
    };
  },

  components: {
    UpdateBeerForm
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