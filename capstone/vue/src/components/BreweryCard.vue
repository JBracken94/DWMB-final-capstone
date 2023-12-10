<template>
    <div class="brewery-card card">
        <div class="card-body">
            <img src="../assests/images/beer" alt="">
            <h2 class="card-title">{{brewery.breweryName}}</h2>
            <p class="card-test">{{ brewery.website }}</p>
            <button class="btn btn-primary" >{{ isSaved ? 'Remove from Saved' : 'Add to Saved' }}</button>
        <router-link :to="{ name: 'brewery-details', params: { breweryId: brewery.breweryId } }" class="btn btn-secondary">View Details</router-link>

        </div>

    </div>
</template>

<script>
export default {
    props: ['brewery'],
    data() {
        return {
            isSaved: false,
        }
    }
}
</script>

<style>
img {
    height: 75px;
}
</style>