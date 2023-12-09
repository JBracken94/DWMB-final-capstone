package com.techelevator.service;

import com.techelevator.dao.BreweryDao;
import com.techelevator.model.BrewSearchDTO;
import com.techelevator.model.Brewery;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
@Component
public class BreweryServiceImpl implements BreweryService {
    private BreweryDao breweryDao;

    public BreweryServiceImpl(BreweryDao breweryDao) {
        this.breweryDao = breweryDao;
    }

    @Override
    public Brewery getBreweryById(int breweryId) {
        Brewery brewery = breweryDao.getBreweryById(breweryId);
        return brewery;
    }

    @Override
    public Brewery getRandomBrewery() {
        Brewery brewery = breweryDao.getRandomBrewery();
        return brewery;
    }

    @Override
    public List<Brewery> getAllBreweries() {

        return breweryDao.getAllBreweries();
    }

    @Override
    public List<Brewery> searchBreweries(BrewSearchDTO searchTerms) {

        return null;
    }

    @Override
    public List<Brewery> getSavedBreweries(Principal principal) {
        List<Brewery> breweries = breweryDao.getSavedBreweries(principal);
        return breweries;
    }

    public Brewery addBreweryToSaved(int breweryId, Principal principal) {
        // TODO add brewery to saved
        Brewery brewery = breweryDao.addBreweryToSaved(breweryId, principal);
        return brewery;
    }

    @Override
    public Brewery createBrewery(Brewery newBrewery, Principal principal) {
        Brewery brewery = breweryDao.createBrewery(newBrewery, principal);
        return brewery;
    }

    @Override
    public Brewery updateBrewery(Brewery updatedBrewery, Principal principal) {
        Brewery brewery = breweryDao.updateBreweryInfo(updatedBrewery, principal);
        return brewery;
    }

    @Override
    public void deleteSavedBrewery(int breweryId, Principal principal) {
        breweryDao.deleteSavedBrewery(breweryId, principal);
    }

    @Override
    public void deleteBrewery(int breweryId, Principal principal) {
        breweryDao.deleteBrewery(breweryId, principal);
    }
}
