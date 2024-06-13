package tn.esprit.shareplate.services;

import tn.esprit.shareplate.entities.Receipt;

import java.util.Date;
import java.util.List;

public interface IReceiptService {
    void addReceipt (Receipt r, Long id);
    void updateReceipt (Receipt r, Long id);
    void deleteReceipt (Long id);
    Receipt findReceiptById (Long id);
    List<Receipt> findAllReceipt();
    List<Receipt> getReceiptByDate(Date dateReceived);
}
