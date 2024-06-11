package tn.esprit.shareplate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.shareplate.entities.Receipt;
@Repository
public interface IReceiptRepository extends JpaRepository<Receipt, Long> {
}
