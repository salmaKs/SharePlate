package tn.esprit.shareplate.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.shareplate.entities.User;
import tn.esprit.shareplate.services.IUserService;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private IUserService iUserService;

    @PostMapping("/addUser")
    public void addUser (@RequestBody User user){
        iUserService.addUser(user);
    }
    @PutMapping("/modifyUser/{id}")
    public void modifyUser (@RequestBody User user , @PathVariable int id){
        iUserService.updateUser(user, id);
    }
    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser (@PathVariable int id){
        iUserService.deleteUser(id);
    }
    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable Long id){
        return iUserService.getById(id);
    }
    @GetMapping("/getallUser")
    public List<User> getAllUser(){
        return iUserService.getall();
    }

}
