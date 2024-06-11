package tn.esprit.shareplate.services;


import tn.esprit.shareplate.entities.User;

import java.util.List;

public interface IUserService {
    void addUser (User u);
    void updateUser (User u, int id);
    void deleteUser (int id);
    List<User> getall();
    User getById(Long id);
}
