import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:9000"
}); 

export default {

  getBrewery(breweryId) {
    return http.get(`/brewery/${breweryId}`);
  },

  getBreweries() {
    return http.get('/breweries');
  },

  searchBreweries(searchTerms) {
    return http.get('/breweries/search', { params: searchTerms });
  },

  getMySavedBreweries() {
    return http.get('/mybreweries');
  },

  addBrewery(brewery) {
    return http.post('/breweries', brewery);
  },

}