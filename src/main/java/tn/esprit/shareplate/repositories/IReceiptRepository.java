package tn.esprit.shareplate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.shareplate.entities.Receipt;

import java.util.Date;
import java.util.List;

@Repository
public interface IReceiptRepository extends JpaRepository<Receipt, Long> {
    List<Receipt> findByDateReceived(Date dateReceived);
}
