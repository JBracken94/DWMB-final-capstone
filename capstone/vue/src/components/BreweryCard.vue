<template>
    <div class="brewery-card card">
        <div class="card-body">
            <img src="../assests/images/IMG-1796.jpg" alt="">
            <h2 class="card-title">{{brewery.breweryName}}</h2>
            <p class="card-test">{{ brewery.website }}</p>

        </div>

    </div>
</template>

<script>
export default {
    props: ['brewery'],
    data() {
        return {
        }
    }
}
</script>

<style>
img {
    height: 75px;
}
</style>