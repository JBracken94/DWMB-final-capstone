<template>
    <review-card v-bind:beer="myBeer" v-for="review in currentReviews" v-bind:key="review.beerReviewId"/>
</template>

<script>
import ReviewCard from '../components/ReviewCard.vue';
import BeerReviewService from '../services/BeerReviewService';
export default {
    components: {
        ReviewCard
    },
    props: ['beer', 'reviews'],
    data() {
        return {
        }
    },
    created() {
    }

}
</script>

<style>

</style>