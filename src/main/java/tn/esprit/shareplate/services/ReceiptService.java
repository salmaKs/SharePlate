package tn.esprit.shareplate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.shareplate.entities.Donation;
import tn.esprit.shareplate.entities.Receipt;
import tn.esprit.shareplate.repositories.IDonationRepository;
import tn.esprit.shareplate.repositories.IReceiptRepository;

import java.util.Date;
import java.util.List;
@Service
public class ReceiptService implements IReceiptService{
    @Autowired
    private IReceiptRepository receiptRepository;
    @Autowired
    private IDonationRepository donationRepository;
    @Override
    public void addReceipt(Receipt r, Long id) {
        Donation donation=donationRepository.findById(id).orElse(null);
        if (donation != null) {
            r.setDonation(donation);
            donation.getReceipt().add(r);
        }
        receiptRepository.save(r);
        donationRepository.save(donation);
    }

    @Override
    public void updateReceipt(Receipt r, Long id) {
        Receipt receipt= receiptRepository.findById(id).orElse(null);
        if (receipt!= null){
            receipt.setDateReceived(r.getDateReceived());
            receipt.setQuantity(r.getQuantity());
            receipt.setUnit(r.getUnit());
            receiptRepository.save(receipt);
        }
    }

    @Override
    public void deleteReceipt(Long id) {
        receiptRepository.deleteById(id);
    }

    @Override
    public Receipt findReceiptById(Long id) {
        return receiptRepository.findById(id).orElse(null);
    }

    @Override
    public List<Receipt> findAllReceipt() {
        return receiptRepository.findAll();
    }

    @Override
    public List<Receipt> getReceiptByDate(Date dateReceived) {
        return receiptRepository.findByDateReceived(dateReceived);
    }
}
