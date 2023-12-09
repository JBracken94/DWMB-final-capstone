<template>
    <h2>brewery details</h2>
    <h1 class="brew-name">{{ brewery.breweryName }}</h1>
</template>

<script>
export default {
    props: ['brewery'],
    data(){
        return{
        beer:{
            beerName: "",
            breweryId: this.brewery.breweryId,
            beerType: "",
            abv:      "",
            labelImage: "",
            description: "",
        }
    }

    }
}
</script>

<style>
.brew-name {
    color: rebeccapurple;
    background: pink;
    width: 400px;
    justify-content: center;
}
</style>