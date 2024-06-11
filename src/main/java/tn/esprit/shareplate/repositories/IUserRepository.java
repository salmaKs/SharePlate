package tn.esprit.shareplate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.shareplate.entities.User;
@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
}
