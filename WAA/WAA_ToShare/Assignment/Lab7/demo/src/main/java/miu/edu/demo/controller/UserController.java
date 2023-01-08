package miu.edu.demo.controller;

import miu.edu.demo.domain.User;
import miu.edu.demo.dto.PostDto;
import miu.edu.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") long id){
        return userService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user){
        userService.createUser(user);
    }

    @GetMapping("/{id}/posts")
    public List<PostDto> getAllPostsByUserId(@PathVariable long id){
        return userService.getAllPostsByUserId(id);
    }

    @RequestMapping(value = "/usersWithMoreThanOnePosts", method = RequestMethod.GET)
    public List<User> findUsersWithMoreThanOnePost(){
        return userService.findUsersWithMoreThanOnePost();
    }
}
