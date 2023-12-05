package com.techelevator.service;

import com.techelevator.model.Beer;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

public interface BeerService {
    public Beer getBeerById(int beerId) throws InterruptedException;
    public List<Beer> getBeersByBreweryId(int breweryId) throws InterruptedException;
    public List<Beer> getSavedBeers(Principal principal) throws InterruptedException;
    public Beer addBeerToSaved(int beerId, Principal principal);
    public Beer updateBeer(int beerId);
    public void deleteSavedBeer(int beerdId, Principal principal);
    public void deleteBeer(int beerId);

}
