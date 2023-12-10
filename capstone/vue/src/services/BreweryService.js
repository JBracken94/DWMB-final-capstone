import axios from 'axios';

export default {
  getBreweries() {
    return axios.get('/breweries');
  },
  
  getBrewery(breweryId) {
    return axios.get(`/breweries/${breweryId}`);
  },

  searchBreweries(searchTerms) {
    return axios.get('/breweries/search', searchTerms); // probably take out
  },

  getMySavedBreweries() {
    return axios.get('/mybreweries');
  },

  createBrewery(brewery) {
    return axios.post('/breweries', brewery)
  },

  addSavedBrewery(breweryId) {
    return axios.post(`/mybreweries/${breweryId}`)
  },

  updateBrewery(brewery) {
    return axios.post(`/breweries/${brewery.breweryId}`, brewery)
  },

  deleteSavedBrewery(breweryId) {
    return axios.delete(`mybreweries/${breweryId}`)
  },

  deleteBrewery(breweryId) {
    return axios.delete(`breweries/${breweryId}`)
  }

  //add saved
  // delete saved
  

}