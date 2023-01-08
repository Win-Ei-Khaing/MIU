package  edu.mum.cs544.Controller;

import  edu.mum.cs544.Domain.User;
import  edu.mum.cs544.Dto.UserResponse;
import  edu.mum.cs544.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<UserResponse> getAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserResponse getById(@PathVariable("id") Integer id){
        return userService.findById(id);
    }

    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }
}
