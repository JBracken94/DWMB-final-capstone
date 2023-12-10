<template>
    <div class="brewery-card card">
        <div class="card-body">
            <img src="../assests/images/placeholders/98205523_161942745346343_8666249890197667840_o0-38d7963c5056a36_38d7975f-5056-a36a-0a0e2b3e87c7f95e.jpg" alt="">
            <h2 class="card-title">{{brewery.breweryName}}</h2>
            <p class="card-test"><a v-bind:href="brewery.website" target="_blank">Visit Us on the Web</a></p>
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