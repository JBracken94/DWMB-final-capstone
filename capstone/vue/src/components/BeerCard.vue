<template>
    <div class="beer-card card">
      <img class="card-img-top" src="../assests/images/placeholders/Asset__4-1080x1080.png" alt="Beer Image">
      <div class="card-body">
        <h2 class="card-title">{{ beer.beerName }}</h2>
        <p class="card-text">{{ beer.beerType }}</p>
        <p class="card-text">{{ beer.abv }}% ABV</p>
        <button class="btn btn-primary" @click="addSaved">{{ saved ? 'Unsave' : 'Save'}}</button>
        <router-link :to="{ name: 'beer-details', params: { id: beer.beerId } }" class="btn btn-secondary">View Details</router-link>

         <!-- BUTTON TO ADD/REMOVE FROM SAVED if savedBeers.contains(beer.beerId)-->
        <!-- CLICKING CARD ROUTES TO BEER DETAILS PAGE -->
      </div>
    </div>
  </template>
  
  <script>
  import BeerService from '../services/BeerService';
import BreweryCardSearchViewVue from '../views/BreweryCardSearchView.vue';
  
  export default {
    props: ['beer'],
    data() {
      return {
        myBeers: [],
        saved: this.checkSaved
      };
    },
    mounted() {
    },
    methods: {
      handleSaved() {
        if (this.checkSaved) {
          this.deleteSaved(this.beer.beerId);
        } else {
          this.addSaved(this.beer.beerId);
        }
      },
      addSaved() {
        BeerService.addSavedBeer(this.beer.beerId)
        .then(response => {
          if (response.status == 201) {
            console.log('success')
          }
        })
        .catch (error => {
          if (error.response.status === 500) {
            this.deleteSaved;
          }
        })
      },
      deleteSaved() {
        BeerService.deleteSavedBeer(this.beer.beerId)
        .then(response => {
          if (response.status == 204) {
            alert('bye bye')
          }
        })
        .catch(error => {
          if (error.response.status == 500) {
            alert('fix this')
          }
        })
      },
      checkSaved() {
          BeerService.getSavedBeers()
          .then(response => {
            let savedBeers = response.data;
            savedBeers.forEach ( current => {
              if(current.beerId == this.beer.beerId) {
                return true;
              } else {
                return false;
              }
            })
          })
        },
        
      },
      updated() {
        this.saved = this.checkSaved
      }
  };
  </script>
  
  <style scoped>
  .card {
    display: flex;
    width: 18rem;

    background-color: gold;
    justify-content: center;
    align-items: center;
    min-height: 50vh;
    border-color: brown;
    border-radius: 30px;
    border-block-width: 10px;
    
    
    margin: auto;
    margin-bottom: 30px;
    
  }
  .card-img-top {
    height: 200px;
    object-fit: cover;
    border-radius: 12px;
  }
  .card-title {
    margin-top: 10px;
    font-size: 1em;
    color:red;
  }
  .card-text {
    margin-top: 5px;
    
  }
  .btn {
    margin-top: 10px;
    color:black;
  }
  </style>