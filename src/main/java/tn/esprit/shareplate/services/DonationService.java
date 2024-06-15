package tn.esprit.shareplate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.shareplate.entities.Donation;
import tn.esprit.shareplate.entities.User;
import tn.esprit.shareplate.entities.donationType;
import tn.esprit.shareplate.repositories.IDonationRepository;
import tn.esprit.shareplate.repositories.IUserRepository;

import java.util.List;
@Service
public class DonationService implements IDonationService {
    @Autowired
    public IDonationRepository donationRepository;
    @Autowired
    public IUserRepository userRepository;
    @Override
    public void addDonation(Donation d, int CIN) {
        User user= userRepository.findByCIN(CIN);
        if (user != null){
            user.getDonations().add(d);
            d.setDonor(user);
            donationRepository.save(d);
            userRepository.save(user);
        }
    }

    @Override
    public void updateDonation(Donation d, Long id) {
        Donation donation= donationRepository.findById(id).orElse(null);
        if (donation != null){
            donation.setAvailability(d.getAvailability());
            donation.setDescription(d.getDescription());
            donation.setPickupLocation(d.getPickupLocation());
            donation.setQuantity(donation.getQuantity());
            donation.setUnit(donation.getUnit());
            donationRepository.save(donation);
        }
    }

    @Override
    public void deleteDonation(Long id) {
        donationRepository.deleteById(id);
    }

    @Override
    public List<Donation> getAll() {
        return donationRepository.findAll();
    }

    @Override
    public List<Donation> getAllOfCIN(int CIN) {
       User user= userRepository.findByCIN(CIN);
       return user.getDonations();
    }

    @Override
    public Donation getDonationById(Long id) {
        return donationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Donation> getDonationByType(donationType donationType) {
        return donationRepository.findByDonationType(donationType);
    }
}
