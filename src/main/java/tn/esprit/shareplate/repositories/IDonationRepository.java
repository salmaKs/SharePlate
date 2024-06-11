package tn.esprit.shareplate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.shareplate.entities.Donation;
@Repository
public interface IDonationRepository extends JpaRepository<Donation, Long> {
}
