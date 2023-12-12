<template>
  <div>
      <form action="">
          <div>
            <select required v-model="newReview.beerRating">
              <option value="" selected disabled >Rating</option>
              <option value="1" >1</option>
              <option value="2" >2</option>
              <option value="3" >3</option>
              <option value="4" >4</option>
              <option value="5" >5</option>
            </select>
        </div>
        <div>
            <label for="reviewText">Your Review:</label>
            <textarea name="reviewText" id="reviewText" cols="30" rows="5" placeholder="What did you think?" v-model="newReview.beerReview"></textarea>
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
            beerId: this.beer.beerId,
            reviewerId: this.reviewer,
            beerRating: 0.0,
            beerReview: 0,
            datePosted: Date.now,
        }
    }
},
computed: {
    reviewer() {
        let user = JSON.parse(window.localStorage.getItem('user'));
        return user.id;
    },
    beerIdent() {
        let it = this.beer.beerId;
        return it;
    }
},
methods: {
    resetForm() {
        this.newReview = {
            beerReviewId: 0,
            beerId: this.beer.beerId,
            reviewerId: this.reviewer,
            beerRating: 0.0,
            beerReview: 0,
            datePosted: Date.now,
        };
    },
    addReview() {
        BeerReviewService.createBeerReview(this.newReview)
        .then(response => {
            if (response.status == 201) {
                alert('success remove this message')
            }
        })
        .catch(error => {
            if (error == 500) {
                alert('createReview failed change this alert')
            }
        });
        this.resetForm;
    }
}
}
</script>

<style>

</style>