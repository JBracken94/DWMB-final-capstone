
<template>
  <h2>Find Us</h2>
  <!-- Add your Google Maps API Key as api-key attribute to demo functionality -->
  <GoogleMap api-key="AIzaSyAWksYN7JVApW1qfftkveDLOTpnQQfdol8" style="width: 500px; height: 500px" :center="brewery" :zoom="15">
      <Marker :options="{ position: center }" />
      <Marker :options="{ position: brewery }" />
    </GoogleMap>
</template>

<script >
import { defineComponent } from "vue";
import { GoogleMap, Marker } from "vue3-google-map";
import axios from 'axios';

export default defineComponent({
  props: ['address'],
  data() {
    return {
    }
  },
  components: { GoogleMap, Marker },
  setup() {
    const center = { lat: 39.152243090211236, lng: -84.46729087516896 }; // center on TE cincinatti
    // 
    // find way to turn address into coordinates
    const brewery = { lat: 40.44619813736048, lng: -80.07601741434895 };

    return { center, brewery };
  },
  methods: {
    getLongLat(addressString) {
      let call = 'https://maps.googleapis.com/maps/api/geocode/json?address=' +
        'addressstring' + '&key=' + 'key';

    }
  },
  created() {
    axios({
      method: 'GET',
      url: '/maps/api/geocode/json?address=',
      baseURL: 'https://maps.googleapis.com'
    })
  }
});
</script>

<style>

</style>