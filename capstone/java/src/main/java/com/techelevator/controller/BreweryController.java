package com.techelevator.controller;

import com.techelevator.service.BreweryServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
public class BreweryController {
    private BreweryServiceImpl breweryServiceImpl;

    public BreweryController(BreweryServiceImpl breweryServiceImpl) {
        this.breweryServiceImpl = breweryServiceImpl;
    }

    @GetMapping("/brewery/{id}") //TODO viewBrewery
    public BigDecimal viewBreweryByID(@PathVariable("id") int breweryId) { // return brewery matching brewery_id
        return BigDecimal.valueOf(breweryId);
    }

    @GetMapping("/breweries")
    public List<String> viewBreweries() {
        List<String> test = new ArrayList<>();
        test.add("test");
        return test;
    }

    @GetMapping("/breweries/search") //TODO brewerySearch
    public List<String> breweryListSearch() { // receive searchDTO with name, city, state
        // return breweries by search (name, city, state)
        // pass SearchDTO to service to call SQL search
        List<String> test = new ArrayList<>();
        test.add("testing");
        return test;
    }

    @GetMapping("/mybreweries") //TODO savedBreweries
    public List<String> viewMySavedBreweries(Principal principal) { //return saved brewery list based on principal
        List<String> test = new ArrayList<>();
        test.add(principal.getName());
        return test;
    }

    @PreAuthorize("hasRole('ROLE_BREWER')")
    @PostMapping("/breweries")
    public String addBrewery(String brewery) {
        return BigDecimal.valueOf(19).toString();
    }
}
