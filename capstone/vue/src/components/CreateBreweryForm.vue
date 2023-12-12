<template>
    <form class="create-brewery-form" v-on:submit.prevent="createBrewery()">
        <label for="breweryName" class="form-label">Brewery Name</label>
        <input class="form-control" type="text" placeholder="Enter Brewery Name" v-model="newBrewery.breweryName">

        <label for="streetAddress" class="form-label">Street Address</label>
        <input class="form-control" type="text" placeholder="Enter Street Address" v-model="newBrewery.streetAddress">

        <label for="city" class="form-label">City</label>
        <input class="form-control" type="text" placeholder="Enter City" v-model="newBrewery.city">

        <label for="state" class="form-label">State</label>
        <input class="form-control" type="text" placeholder="Enter State, example 'PA'" v-model="newBrewery.state">

        <label for="zipCode" class="form-label">ZipCode</label>
        <input class="form-control" type="text" placeholder="Enter ZipCode" v-model="newBrewery.zipcode">

        <label for="dateEst" class="form-label">Date Established</label>
        <input class="form-control" type="text" placeholder="Enter Date Established, example 'YYYY-MM-DD'"
            v-model="newBrewery.dateEst">

        <label for="phoneNumber" class="form-label">Phone Number</label>
        <input class="form-control" type="tel" placeholder="Enter Phone Number, example '(555) 555-5555'"
            v-model="newBrewery.phoneNumber">

        <label for="aboutUs" class="form-label">About Us</label>
        <textarea class="form-control" rows="5" v-model="newBrewery.aboutUs"></textarea>

        <label for="website" class="form-label">Website URL</label>
        <input class="form-control" type="text" placeholder="Enter Web URL, example 'https://yourwesbiturl.com/'"
            v-model="newBrewery.website">

        <label for="logoImage" class="form-label">Logo Image</label>
        <input class="form-control" type="text" placeholder="Enter Logo Image, example 'yourlogo.jpg'"
            v-model="newBrewery.logoImage">

        <button type="submit" class="btn btn-primary">Submit Changes</button>
    </form>
</template>
  
<script>

import BreweryService from '../services/BreweryService'

export default {
    data() {
        return {
            newBrewery: {}
        }
    },

    methods: {

        createBrewery() {
            BreweryService.createBrewery(this.newBrewery)
                .then(response => {
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
  
<style></style>