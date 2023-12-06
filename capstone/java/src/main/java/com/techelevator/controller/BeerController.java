package com.techelevator.controller;

import com.techelevator.model.Beer;
import com.techelevator.service.BeerService;
import com.techelevator.service.BeerServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
public class BeerController {
    private BeerService beerService;

    public BeerController(BeerServiceImpl beerService) { // constructor
        this.beerService = beerService;
    }

    @GetMapping("/beers/{id}") //TODO viewBeer
    public Beer viewBeerByID(@PathVariable("id") int beerId) { // 200 on success, 404 if no beer exists
        // return beer POJO
        Beer beer = beerService.getBeerById(beerId);
        if (beer == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,  "Beer not found.");
        }
        return beer;
    }
    @GetMapping("/brewery/beers/{id}") //TODO viewBeersByBrewery
    public List<Beer> viewBeersByBrewery (@PathVariable("id") int breweryId) { // 200 on success, 204 if empty
        List<Beer> beers = beerService.getBeersByBreweryId(breweryId);
        if (beers.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No beers found for this brewery.");
        }
        return beers;
    }
    @GetMapping("/mybeers") //TODO savedBeers
    public List<Beer> viewMySavedBeers(Principal principal) { //200 and list on success, 204 if list empty
        List<Beer> myBeers = beerService.getSavedBeers(principal);
        if (myBeers.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        return myBeers;
    }
    @PreAuthorize("hasRole('ROLE_BREWER')")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/beers")
    public Beer createBeer(@RequestBody Beer beer, Principal principal) { // 201 on success, 500 if duplicate or failed
        Beer newBeer = beerService.createBeer(beer, principal);
        return newBeer;
    }

    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/beers/mybeers")
    public Beer addSavedBeer(@RequestBody int beerId, Principal principal) { // 201 on success, 500 if no beer exists
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
    @PreAuthorize("isAuthenticated()") // 500 on failed delete, 204 on success
    @DeleteMapping("/mybeers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSavedBeer(@PathVariable("id") int beerId, Principal principal) {
        beerService.deleteSavedBeer(beerId, principal);
    }

    @PreAuthorize("hasRole('ROLE_BREWER')") //authorize but check founderId in SQL
    @DeleteMapping("/beers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("id") int beerID) {
        beerService.deleteBeer(beerID);
    }

}
