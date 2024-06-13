package tn.esprit.shareplate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.shareplate.entities.Donation;
import tn.esprit.shareplate.entities.donationType;

import java.util.List;

@Repository
public interface IDonationRepository extends JpaRepository<Donation, Long> {
    List<Donation> findByDonationType(donationType donationType);
}
