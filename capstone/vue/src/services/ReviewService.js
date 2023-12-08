import axios from 'axios';
export default {

  getBeersReviewById(reviewId) {
    return axios.get(`/beers/reviews/${reviewId}`);
  }, 

  getMyBeersReviews() {
    return axios.get('/beers/myreviews');
  },

  addBeerReview(review) {
    return axios.post('/beers/reviews', review);
  },

  deleteBeerReview(reviewId) {
    return axios.delete(`/beers/review/${reviewId}`);
  }
}