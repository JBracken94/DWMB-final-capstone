<template>
  <div>
  
    
<h2>test</h2>
  </div>
</template>

<script>
export default {
  data() {
    return {
      review: {

      }
    };
  },
  methods: {
    addBeerReview() {
      ReviewService.addBeerReview(this.review)
        .then(response => {
        })
        .catch(error => {
        });
    }
  },
  mounted() {
  }
};
</script>

<style scoped>
</style>