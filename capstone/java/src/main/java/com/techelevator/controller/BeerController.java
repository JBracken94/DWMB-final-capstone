package com.techelevator.controller;

import com.techelevator.model.Beer;
import com.techelevator.service.BeerServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
public class BeerController {
    private BeerServiceImpl beerService;

    public BeerController(BeerServiceImpl beerService) { // constructor
        this.beerService = beerService;
    }

    @GetMapping("/beers/{id}") //TODO viewBeer
    public Beer viewBeerByID(@PathVariable("id") int beerId) { // return beer matching beer_id
        // return beer POJO
        Beer beer = beerService.getBeerById(beerId);
        return beer;
    }
    @GetMapping("/brewery/beers/{id}") //TODO viewBeersByBrewery
    public List<Beer> viewBeersByBrewery (@PathVariable("id") int breweryId) { // return beer list by brewery
        List<Beer> beers = beerService.getBeersByBreweryId(breweryId);
        return beers;
    }
    @GetMapping("/mybeers") //TODO savedBeers
    public List<Beer> viewMySavedBeers(Principal principal) { // return saved beer list based on principal
        List<Beer> test = beerService.getSavedBeers(principal);
        return test;
    }
    @PreAuthorize("hasRole('ROLE_BREWER')")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/beers")
    public Beer createBeer(Beer beer, Principal principal) {
        Beer newBeer = beerService.createBeer(beer, principal);
    }

    @PreAuthorize("hasRole('ROLE_BREWER')")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/beers")
    public Beer addSavedBeer(@RequestBody int beerId, Principal principal) {
        Beer added = beerService.addBeerToSaved(beerId, principal);
        return added;
    }
    @PreAuthorize("hasRole('ROLE_BREWER')")
    @PutMapping("/beers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Beer updateBeer(@RequestBody Beer beer, Principal principal) {
        Beer updatedBeer = beerService.updateBeer(beer, principal);
        return updatedBeer;
    }

    @PreAuthorize("hasRole('ROLE_BREWER')") //authorize but check founderId in SQL
    @DeleteMapping("/beers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("id") int beerID) {
        beerService.deleteBeer(beerID);
    }

}
