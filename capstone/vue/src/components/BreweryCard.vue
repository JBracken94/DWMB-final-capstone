<template>
    <div class="brewery-card brew-card">
        <div class="card-brew-body">
            <h2 class="card-titles">{{brewery.breweryName}}</h2>
            <h4 class="brew-location">{{ brewery.city }}, {{ brewery.state }}</h4>
            <p class="card-test"><a v-bind:href="brewery.website" target="_blank">Visit Us on the Web</a></p>
            <div>
                
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
.brew-location {
    color: red;
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
    font-size: 30px;
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