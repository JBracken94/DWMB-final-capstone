import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:9000"
});

export default {

  getReviewById(reviewId) { 
    return http.get(`/breweries/reviews/${reviewId}`);
  },

  getMyBreweryReviews() {
    return http.get('/breweries/myreviews');
  },

  addReview(review) {
    return http.post('/breweries/reviews', review);
  },

  deleteReview(reviewId) {
    return http.delete(`/breweries/review/${reviewId}`);
  }
}