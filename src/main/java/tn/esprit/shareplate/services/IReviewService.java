package tn.esprit.shareplate.services;

import tn.esprit.shareplate.entities.Review;

import java.util.List;

public interface IReviewService {
    void addReview (Review r);
    void updateReview (Review r , Long id);
    void deleteReview (long id);
    Review findReviewById (Long id);
    List<Review> findAllReview ();
}
