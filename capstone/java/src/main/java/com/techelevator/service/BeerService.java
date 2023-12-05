package com.techelevator.service;

import com.techelevator.model.Beer;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

public interface BeerService {
    public Beer getBeerById(int beerId);
    public List<Beer> getBeersByBreweryId(int breweryId);
    public List<Beer> getSavedBeers(Principal principal);
    public Beer addBeerToSaved(int beerId, Principal principal);
    public Beer updateBeer(int beerId);
    public void deleteSavedBeer(int beerdId, Principal principal);
    public void deleteBeer(int beerId);

}
