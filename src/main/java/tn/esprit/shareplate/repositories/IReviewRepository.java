package tn.esprit.shareplate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.shareplate.entities.Review;
@Repository
public interface IReviewRepository extends JpaRepository<Review, Long> {
}
