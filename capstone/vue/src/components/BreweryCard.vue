<template>
    <div class="brewery-card brew-card">
        <div class="card-brew-body">
            <img src="../assests/images/placeholders/98205523_161942745346343_8666249890197667840_o0-38d7963c5056a36_38d7975f-5056-a36a-0a0e2b3e87c7f95e.jpg" alt="">
            <h2 class="card-titles">{{brewery.breweryName}}</h2>
            <p class="card-test"><a v-bind:href="brewery.website" target="_blank">Visit Us on the Web</a></p>
            <div>
                <button class="btn btn-primary" >{{ isSaved ? 'Remove from Saved' : 'Add to Saved' }}</button>
            <router-link :to="{ name: 'brewery-details', params: { breweryId: brewery.breweryId } }" class="btn btn-secondary">View Details</router-link>
            </div>

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

<style scope>
.card-brew-body {
    display: grid;
    width: 70vh;
   
    justify-content: center;
    align-items: left;
    min-height: 30vh;
    
    border-radius: 40px;
    
    margin-bottom: 40px;
    height: 50px;
    background-image: url('../assests\images/placeholders/brewery-icon.png');
    
    background-size: cover;
    background-position: center;
    height: 100 vh;
 
    
}
.brew-card {
    display: flex;
    width: 35vh;
    min-height: 30vh;
    margin: auto;
    border-radius: 30px;
    margin-bottom: 30px;
    
    
    
  }
  .card-titles {
    font-size: 40px;
    color: white;
    background-color: black;
    
  }

img {
    height: 75px;
    

}
.btn {
    margin-top: 20px;
    
}

</style>