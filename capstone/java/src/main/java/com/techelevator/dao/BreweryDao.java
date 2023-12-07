package com.techelevator.dao;

import com.techelevator.model.BrewSearchDTO;
import com.techelevator.model.Brewery;

import java.security.Principal;
import java.util.List;

public interface BreweryDao {
    Brewery getBreweryById (int breweryId);
    List<Brewery> getAllBreweries();
    List<Brewery> searchBreweries(BrewSearchDTO searchTerms);
    List<Brewery> getSavedBreweries(Principal principal);
    Brewery createBrewery(Brewery newBrewery, Principal principal);
    Brewery updateBreweryInfo(Brewery updatedBrewery, Principal principal);
    void deleteBrewery(int breweryId, Principal principal);
}
