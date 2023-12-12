<template>
    <form class="update-brewery-form" v-on:submit.prevent="updateBrewery(breweryToUpdate)">
        <label for="breweryName" class="form-label">Brewery Name</label>
        <input class="form-control" type="text" placeholder="Update Brewery Name" v-model="updatedBrewery.breweryName" >

        <label for="streetAddress" class="form-label">Street Address</label>
        <input class="form-control" type="text" placeholder="Update Street Address" v-model="updatedBrewery.streetAddress" >

        <label for="city" class="form-label">City</label>
        <input class="form-control" type="text" placeholder="Update City" v-model="updatedBrewery.city" >

        <label for="state" class="form-label">State</label>
        <input class="form-control" type="text" placeholder="Update State, example 'PA'" v-model="updatedBrewery.state" >

        <label for="zipcode" class="form-label">ZipCode</label>
        <input class="form-control" type="text" placeholder="Update ZipCode" v-model="updatedBrewery.zipcode" >

        <label for="dateEst" class="form-label">Date Established</label>
        <input class="form-control" type="text" placeholder="Update Date Established, example 'YYYY-MM-DD'" v-model="updatedBrewery.dateEst" >

        <label for="phoneNumber" class="form-label">Phone Number</label>
        <input class="form-control" type="tel" placeholder="Update Phone Number, example '(555) 555-5555'" v-model="updatedBrewery.phoneNumber" >

        <label for="aboutUs" class="form-label">About Us</label>
        <textarea class="form-control" rows="5" v-model="updatedBrewery.aboutUs" ></textarea>

        <label for="website" class="form-label">Website URL</label>
        <input class="form-control" type="text" placeholder="Update Web URL, example 'https://yourwesbiturl.com/'" v-model="updatedBrewery.website" >

        <label for="logoImage" class="form-label">Logo Image</label>
        <input class="form-control" type="text" placeholder="Update Logo Image, example 'yourlogo.jpg'" v-model="updatedBrewery.logoImage" >

      <button type="submit" class="btn btn-primary">Submit Changes</button>
    </form>
</template>
  
<script>

    import BreweryService from '../services/BreweryService'

    export default {
        data() {
            return {
                updatedBrewery: {}
            }
        },
    
        methods: {

            updateBrewery(breweryToUpdate) {
                BreweryService.updateBrewery(this.updatedBrewery)
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