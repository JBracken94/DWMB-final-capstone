<template>
    <div class="beer-card">
        <img src="src\assests\images\placeholderBeer.jpg" />
        <h2>{{ beer.beerName }}</h2>
        <p>{{ beer.beerType }}</p>
        <p>{{ beer.abv }}% ABV</p>
        <!-- BUTTON TO ADD/REMOVE FROM SAVED if savedBeers.contains(beer.beerId)-->
        <!-- CLICKING CARD ROUTES TO BEER DETAILS PAGE -->
        <router-link :to="{name: 'beer-details', params: {beerId: this.beerId}}"></router-link>

    </div>
</template>
<script>
import BeerService from '../services/BeerService';


export default {
    props: ['beer'],
    savedBeers: [],
    methods: {
        getSaved() {
            BeerService.getSavedBeers()
                .then(response => {
                this.savedBeers = response.data
                })
        }
    }
};
</script>
<style scoped>
img {
    max-width: 100%;
    height: auto;
    border-radius: 5px;
}
h2 {
    margin-top: 10px;
    font-size: 1.2em;
}
p {
    margin-top: 5px;
}
span {
    display: block;
    margin-top: 10px;
    font-weight: bold;
}
</style>
