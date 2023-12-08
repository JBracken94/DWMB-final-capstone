import axios from 'axios';

export default {

  getBrewery(breweryId) {
    return axios.get(`/brewery/${breweryId}`);
  },

  getBreweries() {
    return axios.get('/breweries');
  },

  searchBreweries(searchTerms) {
    return axios.get('/breweries/search', { params: searchTerms });
  },

  getMySavedBreweries() {
    return axios.get('/mybreweries');
  },

  addBrewery(brewery) {
    return axios.post('/breweries', brewery);
  },

}