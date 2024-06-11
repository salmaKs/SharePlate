package tn.esprit.shareplate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.shareplate.entities.Receipt;
import tn.esprit.shareplate.repositories.IReceiptRepository;

import java.util.List;
@Service
public class ReceiptService implements IReceiptService{
    @Autowired
    private IReceiptRepository receiptRepository;
    @Override
    public void addReceipt(Receipt r) {
        receiptRepository.save(r);
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
}
