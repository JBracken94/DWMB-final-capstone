package com.techelevator.controller;

import com.techelevator.service.BeerServiceImpl;
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
public class BeerController {
    private BeerServiceImpl beerServiceImpl;
    public BeerController(BeerServiceImpl beerService) { // constructor
        this.beerServiceImpl = beerService;
    }

    @GetMapping("/beers/{id}") //TODO viewBeer
    public BigDecimal viewBeerByID(@PathVariable("id") int beerId) { // return beer matching beer_id
        // return beer POJO
        return BigDecimal.valueOf(beerId);
    }
    @GetMapping("/beerlists/{id}") //TODO viewBeersByBrewery
    public List<BigDecimal> viewBeersByBrewery (@PathVariable("id") int breweryId) { // return beer list by brewery
        // return
        List<BigDecimal> test = new ArrayList<>();
        test.add(BigDecimal.valueOf(breweryId));
        return test;
    }
    @GetMapping("/mybeers") //TODO savedBeers
    public List<String> viewMySavedBeers(Principal principal) { // return saved beer list based on principal
        List<String> test = new ArrayList<>();
        // principal holds username - convert to ID and pull from beers list
        // 2 SQL calls?
        test.add(principal.getName());
        return test;
    }
    @PreAuthorize("hasRole('ROLE_BREWER')")
    @PostMapping("/beers")
    public String addBeer(String beer) {
        return beer;
    }

}
