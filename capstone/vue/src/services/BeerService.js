import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:9000"
});

export default {
  getBeers() {
    return http.get('/beers');
  },
  getBeerById(beerId) {
    return http.get(`/beers/${beerId}`);
  },

  getBeersByBrewery(breweryId) {
    return http.get(`/brewery/beers/${breweryId}`);
  },

  addSavedBeer(beerId) {
    return http.post('/beers/mybeers', beerId);
  },

  createBeer(beer) {
    return http.post('/beers', beer);
  },

  updateBeer(beer) {
    return http.put(`/beers/${beer.id}`, beer);
  },

  deleteSavedBeer(beerId) {
    return http.delete(`/mybeers/${beerId}`);
  },

  deleteBeer(beerId) {
    return http.delete(`/beers/${beerId}`);
  }
};