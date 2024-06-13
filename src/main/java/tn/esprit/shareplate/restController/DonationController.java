package tn.esprit.shareplate.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.shareplate.entities.Donation;
import tn.esprit.shareplate.entities.DonationDTO;
import tn.esprit.shareplate.entities.User;
import tn.esprit.shareplate.entities.donationType;
import tn.esprit.shareplate.services.IDonationService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
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
    /*@GetMapping("/getallDonation")
    public List<DonationDTO> getAllDonation(){
        List<Donation> donations = donationService.getAll();
        List<DonationDTO> donationDTOS = donations.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return donationDTOS;
    }*/
    @GetMapping("/getallDonation")
    public List<Donation> getAllDonation(){

        return donationService.getAll();
    }

    @GetMapping("/getDonationByType")
    public List<Donation> getDonationByType (@RequestParam donationType donationType) {
        return donationService.getDonationByType(donationType);
    }

    private DonationDTO convertToDto(Donation donation){
        DonationDTO donationDTO = new DonationDTO();
        donationDTO.setDonationType(donation.getDonationType());
        donationDTO.setQuantity(donation.getQuantity());
        donationDTO.setUnit(donation.getUnit());
        donationDTO.setAvailability(donation.getAvailability());
        donationDTO.setPickupLocation(donation.getPickupLocation());
        donationDTO.setDescription(donationDTO.getDescription());
        User user= donation.getDonor();
        if (user != null){
            donationDTO.setName(user.getNom()+ " "+user.getPrenom());

        }else {
            donationDTO.setName("");
        }
        return donationDTO;


    }
}
