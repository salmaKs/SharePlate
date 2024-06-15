package tn.esprit.shareplate.services;


import tn.esprit.shareplate.entities.User;
import tn.esprit.shareplate.entities.gouvTun;
import tn.esprit.shareplate.entities.role;

import javax.management.relation.Role;
import java.util.List;

public interface IUserService {
    void addUser (User u);
    void updateUser (User u, int id);
    void deleteUser (int id);
    List<User> getall();
    User getById(Long id);
    List<User> getUserByRole(role role);
    List<User> getUserByGouvTun(gouvTun gouvTun);
    boolean UserExist(String mail, String pwd);
    boolean userExistAll (User user);
}
