import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:9000"
});

export default {

  getBeerById(beerId) { // 200-OK on success :: 404-NOT FOUND if no beer exists
    return http.get(`/beers/${beerId}`);
  },

  getBeersByBrewery(breweryId) { //200-OK on success (EMPTY LIST STILL RETURNS 200-OK) :: 500-SERVER ERROR if no brewery exists 
    return http.get(`/brewery/beers/${breweryId}`);
  },

  getMySavedBeers() { // 200-OK on success (EMPTY LIST STILL RETURN 200-OK) :: 500-SERVER ERROR on failure
    return http.get('/mybeers');
  },

  addSavedBeer(beerId) { // 201-CREATED on success :: 500-SERVER ERROR if no beer to add (DataIntegrityViolation)
    return http.post('/beers/mybeers', beerId);
  },

  createBeer(beer) { // 201-CREATED on success :: 500-SERVER ERROR if duplicate beer or failure (DUPLICATE VALIDATION IN PROGRESS)
    return http.post('/beers', beer);
  },

  updateBeer(beer) { // 200-OK on success :: 500-SERVER ERROR on failure
    return http.put(`/beers/${beer.id}`, beer)
  },

  deleteSavedBeer(beerId) { // 204-NO CONTENT on success (or if not on fav_beer table) :: 500 on failure
    return http.delete(`/mybeers/${beerId}`);
  },

  deleteBeer(beerId) { // 204-NO CONTENT on success (or if not on beer table) :: 500 on failure (DataIntegrityViolation)
    return http.delete(`/beers/${beerId}`);
  }



}