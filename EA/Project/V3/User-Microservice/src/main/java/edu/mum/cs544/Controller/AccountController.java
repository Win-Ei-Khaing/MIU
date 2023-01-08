package  edu.mum.cs544.Controller;

import  edu.mum.cs544.Domain.User;
import  edu.mum.cs544.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    UserService userService;

    @PutMapping()
    public User updateAccountInfo(@RequestBody User user){
        return userService.updateAccountInfo(user);
    }

    @PutMapping("/{id}/{password}")
    public void updateAccountPassword(@PathVariable("id")Integer id, @PathVariable("password")String password){
         userService.updateAccountPassword(id,password);
    }


    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id")Integer id){
        userService.deleteAccount(id);
    }
}
