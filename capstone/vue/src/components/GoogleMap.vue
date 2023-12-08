
<template>
  <h2>Hey everyone look it's Zack's house</h2>
  <GoogleMap api-key="importedKey" style="width: 100%; height: 500px" :center="center" :zoom="15">
      <Marker :options="{ position: center }" />
      <Marker :options="{ position: brewery }" />
    </GoogleMap>
</template>

<script >
import { defineComponent } from "vue";
import { GoogleMap, Marker } from "vue3-google-map";

export default defineComponent({
  components: { GoogleMap, Marker },
  props: ['address'],
  setup() {
    const center = { lat: 39.152243090211236, lng: -84.46729087516896 }; // center on TE cincinatti
    // 
    // find way to turn address into coordinates
    const brewery = { lat: 40.44619813736048, lng: -80.07601741434895 };

    return { center, brewery };
  },
  data() {
    return {
    }
  },
  computed: {
    apiKey() {
      let key = import.meta.env.MAP_API_KEY;
      return key;
    }
  }
});
</script>

<style>

</style>