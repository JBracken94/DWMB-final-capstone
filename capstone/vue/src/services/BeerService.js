export const getMySavedBeers = () => {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      const savedBeers = [
        {
          beerId: 3,
          beerName: "Brew Bois Lager",
          breweryId: 2,
          beerType: "Lager",
          abv: 5.2,
          labelImage: "bbl.jpg",
          description: "Best beer in town!",
        },
        {
          beerId: 4,
          beerName: "Slurp Juice",
          breweryId: 3,
          beerType: "Sour",
          abv: 9.9,
          labelImage: "sj.jpg",
          description: "1 Victory Royale...",
        },
      ];

      resolve(savedBeers);
    }, 1000); // 1 sec
  });
};

export default {
  getBeerById(beerId) {
    return http.get(`/beers/${beerId}`);
  },

  getBeersByBrewery(breweryId) {
    return http.get(`/brewery/beers/${breweryId}`);
  },

  getMySavedBeers,

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
  },

  // check this get beers working information back end

  getBeers() {
    return http.get('/beers');
  }
};