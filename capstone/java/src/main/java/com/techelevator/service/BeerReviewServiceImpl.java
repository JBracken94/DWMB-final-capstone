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
        BeerReview beerReview = beerReviewDao.getBeerReviewById(beerReviewId);
        return beerReview;
    }

    @Override
    public List<BeerReview> getMyBeerReviews(Principal principal) {
        List<BeerReview> beerReviews = beerReviewDao.getMyBeerReviews(principal);
        return beerReviews;
    }

    @Override
    public BeerReview createBeerReview(BeerReview newBeerReview, Principal principal) {
        BeerReview beerReview = beerReviewDao.createBeerReview(newBeerReview, principal);
        return beerReview;
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
