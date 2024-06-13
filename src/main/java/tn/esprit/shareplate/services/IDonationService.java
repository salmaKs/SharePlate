package tn.esprit.shareplate.services;

import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.shareplate.entities.Donation;
import tn.esprit.shareplate.entities.donationType;

import java.util.List;

public interface IDonationService {
    void addDonation (Donation d);
    void updateDonation(Donation d, Long id);
    void deleteDonation (Long id);
    List<Donation> getAll();
    Donation getDonationById(Long id);
    List<Donation> getDonationByType (donationType donationType);
}
