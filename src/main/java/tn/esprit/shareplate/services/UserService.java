package tn.esprit.shareplate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.shareplate.entities.User;
import tn.esprit.shareplate.repositories.IUserRepository;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public void addUser(User u) {
        userRepository.save(u);
    }

    @Override
    public void updateUser(User u, int id) {
        User user = userRepository.findById((long) id).orElse(null);
        if (user!= null){
            user.setMail(u.getMail());
            user.setDateNaissance(u.getDateNaissance());
            user.setGouvTun(u.getGouvTun());
            user.setTel(u.getTel());
            userRepository.save(user);
        }
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById((long) id);
    }

    @Override
    public List<User> getall() {
return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
