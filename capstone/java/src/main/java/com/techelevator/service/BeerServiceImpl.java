package com.techelevator.service;

import com.techelevator.model.Beer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
@Component
public class BeerServiceImpl implements BeerService{

    @Override
    public Beer getBeerById(int beerId) {
        return null;
    }

    @Override
    public List<Beer> getBeersByBreweryId(int breweryId) {
        return null;
    }

    @Override
    public List<Beer> getSavedBeers(Principal principal) {
        return null;
    }

    @Override
    public Beer addBeerToSaved(int beerId, Principal principal) {
        return null;
    }

    @Override
    public Beer createBeer(Beer beer, Principal principal) {
        return null;
    }

    @Override
    public Beer updateBeer(Beer beer, Principal principal) {
        return null;
    }

    @Override
    public void deleteSavedBeer(int beerdId, Principal principal) {

    }

    @Override
    public void deleteBeer(int beerId) {

    }
}
