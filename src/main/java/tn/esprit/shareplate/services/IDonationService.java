package tn.esprit.shareplate.services;

import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.shareplate.entities.Donation;

import java.util.List;

public interface IDonationService {
    void addDonation (Donation d);
    void updateDonation(Donation d, Long id);
    void deleteDonation (Long id);
    List<Donation> getAll();
    Donation getDonationById(Long id);
}
