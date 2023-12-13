<template>
  <div>
      <form action="">
          <div>
            <select required v-model.number="newReview.beerRating">
              <option selected disabled >Rating</option>
              <option value=1>1</option>
              <option value=2>2</option>
              <option value=3>3</option>
              <option value=4>4</option>
              <option value=5>5</option>
            </select>
        </div>
        <div>
            <label for="reviewText">Your Review:</label>
            <textarea name="reviewText" id="reviewText" cols="30" rows="5" 
            placeholder="What did you think?" v-model="newReview.beerReview" required></textarea>
        </div>
          <input type="submit" @click.prevent="addReview">
        </form>
  </div>

</template>

<script>
import BeerReviewService from '../services/BeerReviewService';
export default {
    props: ['beer'],
data() {
    return{
        newReview: {
            beerReviewId: 0,
            beerId: this.$route.params.id,
            reviewerId: this.$store.state.user.id,
            beerRating: 0.0,
            beerReview: '',
            datePosted: new Date(2023, 12, 12),
        }
    }
},
computed: {
    reviewer() {
        let user = JSON.parse(window.localStorage.getItem('user'));
        return user.id;
    }
},
methods: {
    resetForm() {
        this.newReview = {
            beerReviewId: 0,
            beerId: this.$store.state.beer.beerId,
            reviewerId: this.reviewer,
            beerRating: 0.0,
            beerReview: 0,
            datePosted: new Date(2023, 12, 12),
        };
    },
    addReview() {
        BeerReviewService.createBeerReview(this.newReview)
        .then(response => {
            if (response.status == 201) {
                this.$store.dispatch('getUpdatedReviews', this.$store.state.beer.beerId);
            }
        })
        .catch(error => {
            if (error == 500) {
                alert('createReview failed change this alert')
            }
        });
        this.resetForm();
    }
}
}
</script>

<style>

</style>