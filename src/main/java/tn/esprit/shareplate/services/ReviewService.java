package tn.esprit.shareplate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.shareplate.entities.Review;
import tn.esprit.shareplate.repositories.IReviewRepository;

import java.util.List;
@Service
public class ReviewService implements IReviewService{
    @Autowired
    private IReviewRepository reviewRepository;
    @Override
    public void addReview(Review r) {
       reviewRepository.save(r);
    }

    @Override
    public void updateReview(Review r, Long id) {
        Review review = reviewRepository.findById(id).orElse(null);
        if (review!= null){
            review.setComment(r.getComment());
            review.setRating(r.getRating());
            reviewRepository.save(review);
        }

    }

    @Override
    public void deleteReview(long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public Review findReviewById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    @Override
    public List<Review> findAllReview() {
        return reviewRepository.findAll();
    }
}
