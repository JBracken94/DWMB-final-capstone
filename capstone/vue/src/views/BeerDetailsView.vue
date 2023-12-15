<template>
  
    <div class="review-update">
      <h2 class="beer-dets">DWMB Reviews</h2>

      <h3 class="beer-name">
        {{ beer.beerName }}
      </h3>

      <h4 class="beer-type">
        {{ beer.beerType }} :: {{ beer.abv }}%
      </h4>
      <p class="desc">{{ beer.description }}</p>

        <!-- <button v-show="isFounder" @click="this.$store.state.showUpdateBeerForm = !this.$store.state.showUpdateBeerForm">
          {{ this.$store.state.showUpdateBeerForm ? 'Hide Update Beer' : 'Update Beer Info'}}</button> -->

      <button class="update-beer-btn" @click="this.$store.state.showUpdateBeerForm = !this.$store.state.showUpdateBeerForm">
        {{ this.$store.state.showUpdateBeerForm ? 'Hide Update Beer' : 'Update Beer Info'}}</button>
      <update-beer-form class="update-form" v-show="this.$store.state.showUpdateBeerForm" />

      <button class="add-review-btn" @click="this.$store.state.showReviewForm = !this.$store.state.showReviewForm">
        {{ this.$store.state.showReviewForm ? 'Hide Add Review' : 'Add A Review'}}</button>
      <create-review class="review-form" v-bind:beer="this.$store.state.beer" v-show="this.$store.state.showReviewForm" />

      <button class="delete-beer-btn" @click="deleteBeer()">Delete Beer</button>
      <review-list v-bind:beer="this.$store.state.beer" v-bind:reviews="this.$store.state.reviews" />
    </div>
    
  
</template>

<script>

import BeerService from '../services/BeerService';
import UpdateBeerForm from '../components/UpdateBeerForm.vue';
import ReviewList from '../components/ReviewList.vue';
import BeerReviewService from '../services/BeerReviewService';
import BreweryService from '../services/BreweryService';
import CreateReview from '../components/CreateReview.vue';
import { routerKey } from 'vue-router';


export default {
  data() {
    return {
      beer: {},
      reviews: [],
      myBrewery: {
      },
      showUpBeerForm: false,
      showReviewForm: false,
      isFounder: false,
    };
  },

  components: {
    UpdateBeerForm,
    ReviewList,
    CreateReview
  },
  methods: {
    deleteBeer() {
      if (confirm) {
        BeerService.deleteBeer(this.$route.params.id)
        .then(response => {
          if (response.status == 204) {
            this.$store.commit('SET_NOTIFICATION',
            {
              message: `${this.beer.beerName} has been deleted.`,
              type: 'success'
            })
            this.refreshBeers;
            this.$router.go(-1);
          }
        })
        .catch(error => {
          if(error) {
            console.log(error.message)
            this.$store.commit('SET_NOTIFICATION',
            {
              message: `Unable to delete this beer.`,
              type: 'error'
            })
          }
        })
      }
    },
    refreshBeers() {
      BeerService.getBeers()
      .then(response => {
        const currBeers = response.data;
        this.$store.commit('SET_BEERS', currBeers);
      })
    }
  },
  created() {
    BeerService.getBeerById(this.$route.params.id)
      .then(response => {
        this.beer = response.data;
        this.$store.commit('SET_BEER', this.beer);
        // needs to run on beer update
        BreweryService.getBreweryById(this.beer.breweryId)
          .then(response => {
            this.myBrewery = response.data;
            this.$store.commit('SET_BREWERY', this.myBrewery);
          });
      });
    BeerReviewService.getReviewsByBeerId(this.$route.params.id)
      .then(response => {
        this.reviews = response.data;
        this.$store.commit('SET_REVIEWS', this.reviews);
      });

  },
  computed: {
    // isFounder() {
    //   let user = JSON.parse(window.localStorage.getItem('user'));
    //   return user.id == this.myBrewery.founderId;
    // },
    
    brewId() {
      return this.beer.breweryId;
    }
  }
};
</script>

<style>

.beer-dets {
  color: brown;
  padding-top: 60px;
}
.desc {
  color: brown;
  font-size: x-large;
  
}

.beer-name {
  color: #e79115;
}

.beer-type {
  color: #e79115;
}

.form-label {
  font-weight: bold;
}

.form-control {
  margin-bottom: 10px;
}

.update-beer-btn {
  color: #e79115;
  display: grid;
  width: 40vh;
  background-color: brown;
  justify-content: center;
  align-items: center;
  border-radius: 10px;
  font-size: 20px;
  margin: auto;
}

.update-form {
  color: #e79115;
  display: grid;
  justify-content: center;
  align-items: center;

  width: 40vh;
  background-color: brown;
  border-radius: 10px;
  font-size: 20px;
  margin: auto;
  
}
.delete-beer-btn {
  color: #e79115;
  display: grid;
  width: 40vh;
  background-color: brown;
  justify-content: center;
  align-items: center;
  border-radius: 10px;
  font-size: 20px;
  margin: auto;
}

.add-review-btn {
  color: #e79115;
  display: grid;
  width: 40vh;
  background-color: brown;
  justify-content: center;
  align-items: center;
  border-radius: 10px;
  font-size: 20px;
  margin: auto;
}

.review-form {
  color: #e79115;
  display: grid;
  justify-content: center;
  align-items: center;

  width: 40vh;
  background-color: brown;
  border-radius: 10px;
  font-size: 20px;
  margin: auto;
}

.review-update {
  margin-left: 200px;
}

</style>