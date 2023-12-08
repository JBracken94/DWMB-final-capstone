<template>
    <div class="beer-card">
        <img :src="beer.image" alt="Beer Image" />
        <h2>{{ beer.beerName }}</h2>
        <p>{{ beer.beerType }}</p>
        <p>{{ beer.abv }}% ABV</p>

    </div>
</template>
<script>


export default {
    props: ['beer'],
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
