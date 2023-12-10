
<template>
  <div v-show="showMap" >
    <h2>Find Us</h2>
    <!-- Add your Google Maps API Key as api-key attribute to demo functionality -->
    <GoogleMap api-key="AIzaSyAWksYN7JVApW1qfftkveDLOTpnQQfdol8" style="width: 500px; height: 500px" :center="{lat: this.latitude, lng: this.longitude}"
      :zoom="15">
      <Marker :options="{ position: center }" />
      <Marker :options="{ position: {lat: this.latitude, lng: this.longitude} }" />
    </GoogleMap>
  </div>
</template>

<script >
import { defineComponent } from "vue";
import { GoogleMap, Marker } from "vue3-google-map";
import LocationService from '../services/LocationService';



// function getAddressString(brew) {
//       let fullAddress = brew.streetAddress + ' ' + brew.city + ' ' + brew.state + ' ' + brew.zipcode;
//       let fixed = fullAddress.replaceAll(' ', '%');
//       return fixed;
//     }

export default defineComponent({
  props: ['brew', 'address'],
  data() {
    return {
      longitude: 39.15272567117034,
      latitude: -84.46692609260063,
      resp: {meatball: 'sauce'},
      showMap: false,
    }
  },
  components: { GoogleMap, Marker },
  setup() {
    const center = { lat: 39.152243090211236, lng: -84.46729087516896 }; // center on TE cincinatti

    // find way to turn address into coordinates
    // const brewery = { lat: 40.44619813736048, lng: -80.07601741434895 };

    return { center };
  },
  methods: {
    setMap() {
      
    }
  },
  created() {
    LocationService.getLocation(`${this.address}` + '&key=AIzaSyAWksYN7JVApW1qfftkveDLOTpnQQfdol8')
    .then(response => {
      if (response.data.results.length > 0) {
        this.response = response.data;
        this.longitude = response.data.results[0].geometry.location.lng;
        this.latitude = response.data.results[0].geometry.location.lat;
        this.showMap = true
      } else {
        this.showMap = false;
      }
    })
    .catch(error => {
      if (error == 400) {
        this.showMap = false;
      }
    })
  },
});
</script>

<style></style>