<template>
    <review-card v-bind:beer="beer" v-for="review in reviews" v-bind:key="review.beerReviewId"/>
</template>

<script>
import ReviewCard from '../components/ReviewCard.vue';
import BeerReviewService from '../services/BeerReviewService';
export default {
    components: {
        ReviewCard
    },
    props: ['beer'],
    data() {
        return {
            reviews: [],
        }
    },
    created() {
        BeerReviewService.getReviewsByBeerId(this.beer.beerId)
        .then(response => {
            this.reviews = response.data;
        })
    }

}
</script>

<style>

</style>