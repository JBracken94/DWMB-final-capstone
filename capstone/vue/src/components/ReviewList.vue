<template>
    <review-card v-bind:beer="beer" v-for="review in reviews" v-bind:key="review.beerReviewId"/>
</template>

<script>
import ReviewCard from './ReviewCard.vue';
import BeerReviewService from '../services/BeerReviewService';
export default {
    components: {
        ReviewCard
    },
    data() {
        return {
            reviews: [],
        }
    },
    props: ['beer'],
    created() {
        BeerReviewService.getMyBeersReviews(this.beer.beerId)
    }

}
</script>

<style>

</style>