<template>
    <div class="beer-card card">
      <img class="card-img-top" src="../assests/images/placeholders/Asset__4-1080x1080.png" alt="Beer Image">
      <div class="card-body">
        <h2 class="card-title">{{ beer.beerName }}</h2>
        <p class="card-text">{{ beer.beerType }}</p>
        <p class="card-text">{{ beer.abv }}% ABV</p>
        <button class="btn btn-primary" @click="toggleSaved">{{ isSaved ? 'Remove from Saved' : 'Add to Saved' }}</button>
        <router-link :to="{ name: 'beer-details', params: { id: beer.beerId } }" class="btn btn-secondary">View Details</router-link>

         <!-- BUTTON TO ADD/REMOVE FROM SAVED if savedBeers.contains(beer.beerId)-->
        <!-- CLICKING CARD ROUTES TO BEER DETAILS PAGE -->
      </div>
    </div>
  </template>
  
  <script>
  import BeerService from '../services/BeerService';
  
  export default {
    props: ['beer'],
    data() {
      return {
        isSaved: false
      };
    },
    mounted() {

      // I would need to check if the beer is already saved only when the componenet is mounted
      this.checkIfSaved();
    },
    methods: {
      checkIfSaved() {
        
        // this method will check if the beer is saved
      
        // BeerService.isBeerSaved(this.beer.beerId)
        //   .then(response => {
        //     this.isSaved = response.data.isSaved;
        //   })
        //   .catch(error => {
        //     console.error("Error checking saved state:", error);
        //   });
      },
      toggleSaved() {
        if (this.isSaved) {
          BeerService.removeFromSavedBeers(this.beer.beerId)
            .then(() => {
              this.isSaved = false;
            })
            .catch(error => {
              console.error("Error removing from saved beers:", error);
            });
        } else {
          BeerService.addToSavedBeers(this.beer.beerId)
            .then(() => {
              this.isSaved = true;
            })
            .catch(error => {
              console.error("Error adding to saved beers:", error);
            });
        }
      }
    }
  };
  </script>
  
  <style scoped>
  .card {
    width: 18rem;
    margin: 1rem;
  }
  .card-img-top {
    height: 200px;
    object-fit: cover;
    border-radius: 12px;
  }
  .card-title {
    margin-top: 10px;
    font-size: 1.2em;
  }
  .card-text {
    margin-top: 5px;
  }
  .btn {
    margin-top: 10px;
  }
  </style>