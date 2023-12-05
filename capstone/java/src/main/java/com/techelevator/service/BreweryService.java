package com.techelevator.service;

import com.techelevator.model.BrewSearchDTO;
import com.techelevator.model.Brewery;

import java.security.Principal;
import java.util.List;

public interface BreweryService {
    public Brewery getBreweryById(int breweryId);
    public List<Brewery> getAllBreweries();
    public List<Brewery> searchBreweries(BrewSearchDTO searchTerms);
    public List<Brewery> getSavedBreweries(Principal principal);
    public Brewery createBrewery(Brewery newBrewery, Principal principal);
    public Brewery updateBrewery(Brewery updatedBrewery, Principal principal);
    public void deleteBrewery(int breweryId, Principal principal);
}
