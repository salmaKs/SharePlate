package tn.esprit.shareplate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.shareplate.entities.User;
import tn.esprit.shareplate.entities.gouvTun;
import tn.esprit.shareplate.entities.role;
import tn.esprit.shareplate.entities.typeDonor;

import javax.management.relation.Role;
import java.util.Date;
import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    List<User> findByRole(role role);

    List<User> findByGouvTun(gouvTun gouvTun);

    User findByMailAndPassword(String mail, String pwd);

    User findByCIN(int cin);




    User findByNomAndPrenomAndDateNaissanceAndMailAndTelAndCIN(String nom, String prenom, Date dateNaissance, String mail, int tel, int cin);
}
