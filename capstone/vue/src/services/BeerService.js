import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:9000"
}); 

export default {

  getBeerById(beerId) {
    return http.get(`/beers/${beerId}`);
  },

  getBeersByBrewery(breweryId) {
    return http.get(`/brewery/beers/${breweryId}`);
  },

  getMySavedBeers() {
    return http.get('/mybeers');
  },

  addSavedBeer(beerId) {
    return http.post('/beers', beerId);
  },

}