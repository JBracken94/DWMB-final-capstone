package com.techelevator.controller;

import com.techelevator.model.Brewery;
import com.techelevator.service.BreweryServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.security.Principal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
public class BreweryController {
    private BreweryServiceImpl breweryServiceImpl;
    private Brewery breweryTest = new Brewery(1, "166 butt lane", "derry", "PA", 15627,
                                    Date.from(Instant.now()), 10162, "hey it's us the brewery that you love wow",
                            "www.wwwwww.www", "imagepath", 3);

    public BreweryController(BreweryServiceImpl breweryServiceImpl) {
        this.breweryServiceImpl = breweryServiceImpl;
    }

    @GetMapping("/brewery/{id}") //TODO viewBrewery
    public Brewery viewBreweryByID(@PathVariable("id") int breweryId) { // return brewery matching brewery_id
        return breweryTest;
    }

    @GetMapping("/breweries")
    public List<Brewery> viewBreweries() {
        List<Brewery> test = new ArrayList<>();
        test.add(breweryTest);
        return test;
    }

    @GetMapping("/breweries/search") //TODO brewerySearch
    public List<Brewery> breweryListSearch() { // receive searchDTO with name, city, state
        // return breweries by search (name, city, state)
        // pass SearchDTO to service to call SQL search
        List<Brewery> test = new ArrayList<>();
        test.add(breweryTest);
        return test;
    }

    @GetMapping("/mybreweries") //TODO savedBreweries
    public List<Brewery> viewMySavedBreweries(Principal principal) { //return saved brewery list based on principal
        List<Brewery> test = new ArrayList<>();
        test.add(breweryTest);
        return test;
    }

    @PreAuthorize("hasRole('ROLE_BREWER')")
    @PostMapping("/breweries")
    public Brewery addBrewery(Brewery breweryTest) {
        return breweryTest;
    }
}
