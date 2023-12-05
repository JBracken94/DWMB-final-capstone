import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:9000"
});

export default {

  getBeersReviewById(reviewId) {
    return http.get(`/beers/reviews/${reviewId}`);
  }, 

  getMyBeersReviews() {
    return http.get('/beers/myreviews');
  },

  addBeerReview(review) {
    return http.post('/beers/reviews', review);
  },

  deleteBeerReview(reviewId) {
    return http.delete(`/beers/review/${reviewId}`);
  }
}