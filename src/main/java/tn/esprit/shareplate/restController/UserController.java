package tn.esprit.shareplate.restController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.shareplate.entities.User;
import tn.esprit.shareplate.entities.gouvTun;
import tn.esprit.shareplate.entities.role;
import tn.esprit.shareplate.services.IUserService;

import javax.management.relation.Role;
import java.util.List;

@RestController
@CrossOrigin("*")
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
    @GetMapping("/getUserByRole")
    public List<User> getUserByRole (@RequestParam role role) {return iUserService.getUserByRole(role);}
    @GetMapping("/getUserByGouv")
    public List<User> getUserByGouv(@RequestParam gouvTun gouvTun) {return iUserService.getUserByGouvTun(gouvTun);}
    @GetMapping("/userExist")
    public boolean userExist (@RequestParam String mail, @RequestParam String pwd){
        return iUserService.UserExist(mail, pwd);
    }
    @GetMapping("/allexist")
    public boolean userAllExist(@RequestParam("user") String userJson) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            User user = objectMapper.readValue(userJson, User.class);
            return iUserService.userExistAll(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return false;
        }
    }


}
