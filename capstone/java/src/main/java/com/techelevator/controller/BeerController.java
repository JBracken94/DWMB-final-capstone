package com.techelevator.controller;

import com.techelevator.model.Beer;
import com.techelevator.service.BeerServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
public class BeerController {
    private Beer testBeer = new Beer(1, "beertest", 1, "stout", 5, "none", "mmmmmmm delicion beer");
    private BeerServiceImpl beerServiceImpl;
    private Beer testBeer2 = new Beer(1,"testbeer",1,"stout",99,"image","wowbeer");
    public BeerController(BeerServiceImpl beerService) { // constructor
        this.beerServiceImpl = beerService;
    }

    @GetMapping("/beers/{id}") //TODO viewBeer
    public Beer viewBeerByID(@PathVariable("id") int beerId) { // return beer matching beer_id
        // return beer POJO
        return testBeer;
    }
    @GetMapping("/beerlists/{id}") //TODO viewBeersByBrewery
    public List<Beer> viewBeersByBrewery (@PathVariable("id") int breweryId) { // return beer list by brewery
        // return
        List<Beer> test = new ArrayList<>();
        test.add(testBeer2);
        test.add(testBeer);
        return test;
    }
    @GetMapping("/mybeers") //TODO savedBeers
    public List<Beer> viewMySavedBeers(Principal principal) { // return saved beer list based on principal
        List<Beer> test = new ArrayList<>();
        // principal holds username - convert to ID and pull from beers list
        // 2 SQL calls?
        test.add(testBeer);
        test.add(testBeer2);
        return test;
    }
    @PreAuthorize("hasRole('ROLE_BREWER')")
    @PostMapping("/beers")
    public Beer addBeer(@RequestBody Beer beer) {
        beer.setAbv(45);
        return beer;
    }

}
