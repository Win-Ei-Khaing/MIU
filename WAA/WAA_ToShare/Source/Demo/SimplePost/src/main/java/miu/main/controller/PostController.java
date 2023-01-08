package miu.main.controller;

import miu.main.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import miu.main.service.PostService;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class PostController {


    @Autowired
    PostService postService;

    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @GetMapping("/posts")
    public List<Post> getPosts(){
        List<Post> posts =  postService.findAll();
        return posts;
    }


    @GetMapping("/posts/{id}")
    public Optional<Post> getPostById(@PathVariable String id){

        Optional<Post> p=  postService.findById(Long.parseLong(id));
        return  p;
    }

    @GetMapping("/admin")
    public String inValidTest2(){
        return "OK";
    }


}
