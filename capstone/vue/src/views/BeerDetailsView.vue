<template>
  
    <div class="review-update">
      <h2 class="beer-dets">DWMB Reviews</h2>

      <h3 class="beer-name">
        {{ beer.beerName }}
      </h3>

      <h4 class="beer-type">
        {{ beer.beerType }} :: {{ beer.abv }}%
      </h4>
      <p>{{ beer.description }}</p>

        <!-- <button v-show="isFounder" @click="this.$store.state.showUpdateBeerForm = !this.$store.state.showUpdateBeerForm">
          {{ this.$store.state.showUpdateBeerForm ? 'Hide Update Beer' : 'Update Beer Info'}}</button> -->

      <button class="update-beer-btn" @click="this.$store.state.showUpdateBeerForm = !this.$store.state.showUpdateBeerForm">
        {{ this.$store.state.showUpdateBeerForm ? 'Hide Update Beer' : 'Update Beer Info'}}</button>
      <update-beer-form class="update-form" v-show="this.$store.state.showUpdateBeerForm" />

      <button class="add-review-btn" @click="this.$store.state.showReviewForm = !this.$store.state.showReviewForm">
        {{ this.$store.state.showReviewForm ? 'Hide Add Review' : 'Add A Review'}}</button>
      <create-review class="review-form" v-bind:beer="this.$store.state.beer" v-show="this.$store.state.showReviewForm" />

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
  // take note i need to make 200 or 201 or 404  basically the success and error situation 

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

.beer-name {
  color: gold;
}

.beer-type {
  color: goldenrod;
}

.form-label {
  font-weight: bold;
}

.form-control {
  margin-bottom: 10px;
}

.update-beer-btn {
  color: goldenrod;
  display: grid;
  width: 40vh;
  background-color: brown;
  justify-content: center;
  align-items: center;
  border-radius: 10px;
  font-size: 20px;
  /* margin-left: 750px; */
}

.update-form {
  color: goldenrod;
  display: grid;
  justify-content: center;
  align-items: center;

  width: 40vh;
  background-color: brown;
  border-radius: 10px;
  font-size: 20px;
}

.add-review-btn {
  color: goldenrod;
  display: grid;
  width: 40vh;
  background-color: brown;
  justify-content: center;
  align-items: center;
  border-radius: 10px;
  font-size: 20px;
  /* margin-left: 750px; */
}

.review-form {
  color: goldenrod;
  display: grid;
  justify-content: center;
  align-items: center;

  width: 40vh;
  height: 5vh;
  /* background-color: brown; */
  border-radius: 10px;
  font-size: 20px;
}

.review-update {
  margin-left: 200px;
}

</style>