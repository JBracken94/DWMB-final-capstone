package com.techelevator.service;

import com.techelevator.dao.BeerReviewDao;
import com.techelevator.model.BeerReview;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
@Component
public class BeerReviewServiceImpl implements BeerReviewService {
    private BeerReviewDao beerReviewDao;
    public BeerReviewServiceImpl(BeerReviewDao beerReviewDao) {
        this.beerReviewDao = beerReviewDao;
    }
    @Override
    public List<BeerReview> getAllBeerReviews() {
        List<BeerReview> beers = beerReviewDao.getAllBeerReviews();
        return beers;
    }

    @Override
    public BeerReview getBeerReviewById(int beerReviewId) {
        beerReviewDao.getBeerReviewById(beerReviewId);
        return null;
    }

    @Override
    public List<BeerReview> getMyBeerReviews(Principal principal) {
        beerReviewDao.getMyBeerReviews(principal);
        return null;
    }

    @Override
    public BeerReview createBeerReview(BeerReview newBeerReview, Principal principal) {
        beerReviewDao.createBeerReview(newBeerReview);
        return null;
    }

    @Override
    public BeerReview updateBeerReview(BeerReview updatedBeerReview, Principal principal) {
        return null;
    }

    @Override
    public void deleteBeerReview(int beerId, Principal principal) {
        System.out.println("delete beer");
    }
}
