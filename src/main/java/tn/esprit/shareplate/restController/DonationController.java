package tn.esprit.shareplate.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.shareplate.entities.Donation;
import tn.esprit.shareplate.entities.User;
import tn.esprit.shareplate.services.IDonationService;

import java.util.List;

@RestController
public class DonationController {
    @Autowired
    private IDonationService donationService;

    @PostMapping("/addDonation")
    public void addDonation (@RequestBody Donation donation){
        donationService.addDonation(donation);
    }
    @PutMapping("/modifyDonation/{id}")
    public void modifyDonation (@RequestBody Donation donation , @PathVariable Long id){
        donationService.updateDonation(donation, id);
    }
    @DeleteMapping("/deleteDonation/{id}")
    public void deleteDonation (@PathVariable Long id){
        donationService.deleteDonation(id);
    }
    @GetMapping("/getDonationById/{id}")
    public Donation getDonationById(@PathVariable Long id){
        return donationService.getDonationById(id);
    }
    @GetMapping("/getallDonation")
    public List<Donation> getAllDonation(){
        return donationService.getAll();
    }
}
