<template>
    <review-card v-for="review in reviews" v-bind:review="review" v-bind:key="review.beerReviewId"/>
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