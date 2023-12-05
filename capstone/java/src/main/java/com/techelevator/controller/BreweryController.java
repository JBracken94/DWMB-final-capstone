package com.techelevator.controller;

import com.techelevator.model.BrewSearchDTO;
import com.techelevator.model.Brewery;
import com.techelevator.service.BreweryService;
import com.techelevator.service.BreweryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
public class BreweryController {
    private BreweryService breweryService;

    public BreweryController(BreweryServiceImpl breweryService) {
        this.breweryService = breweryService;
    }

    @GetMapping("/breweries")
    public List<Brewery> viewBreweries() {
        List<Brewery> allBreweries = breweryService.getAllBreweries();
        return allBreweries;
    }

    @GetMapping("/brewery/{id}") //TODO viewBrewery
    public Brewery viewBreweryByID(@PathVariable("id") int breweryId) { // return brewery matching brewery_id
        Brewery brewery = breweryService.getBreweryById(breweryId);
        return brewery;
    }

    @GetMapping("/breweries/search") //TODO brewerySearch
    public List<Brewery> breweryListSearch(BrewSearchDTO searchTerms) { // receive searchDTO with name, city, state
        // return breweries by search (name, city, state)
        // pass SearchDTO to service to call SQL search
        List<Brewery> filteredBreweries = breweryService.searchBreweries(searchTerms);
        return filteredBreweries;
    }

    @GetMapping("/mybreweries") //TODO savedBreweries
    public List<Brewery> viewMySavedBreweries(Principal principal) { //return saved brewery list based on principal
        List<Brewery> savedBreweries = breweryService.getSavedBreweries(principal);
        return savedBreweries;
    }
    @PreAuthorize("hasRole('ROLE_BREWER')")
    @PutMapping("/breweries/")
    public Brewery updateBrewery(Brewery updatedBrewery, Principal principal) {
        Brewery newBrewery = breweryService.updateBrewery(updatedBrewery, principal);
        return newBrewery;
    }

    @PreAuthorize("hasRole('ROLE_BREWER')")
    @PostMapping("/breweries")
    public Brewery addBrewery(Brewery breweryTest, Principal principal) {
        Brewery createdBrewery = breweryService.createBrewery(breweryTest, principal);
        return createdBrewery;
    }
    @PreAuthorize("hasRole('ROLE_BREWER')")
    @PostMapping("/breweries/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBrewery(@PathVariable("id") int breweryId, Principal principal) {
        breweryService.deleteBrewery(breweryId, principal);
    }
}
