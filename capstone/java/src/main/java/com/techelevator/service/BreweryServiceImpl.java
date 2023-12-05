package com.techelevator.service;

import com.techelevator.model.BrewSearchDTO;
import com.techelevator.model.Brewery;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class BreweryServiceImpl implements BreweryService{
    @Override
    public Brewery getBreweryById(int breweryId) throws InterruptedException {
        return null;
    }

    @Override
    public List<Brewery> getAllBreweries() throws InterruptedException {
        return null;
    }

    @Override
    public List<Brewery> searchBreweries(BrewSearchDTO searchTerms) throws InterruptedException {
        return null;
    }

    @Override
    public List<Brewery> getSavedBreweries(Principal principal) throws InterruptedException {
        return null;
    }

    @Override
    public Brewery createBrewery(Brewery newBrewery, Principal principal) {
        return null;
    }

    @Override
    public Brewery updateBrewery(Brewery updatedBrewery, Principal principal) {
        return null;
    }

    @Override
    public void deleteBrewery(int breweryId, Principal principal) {

    }
}
