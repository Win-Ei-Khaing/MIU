package com.example.demoSep21.controller;

import com.example.demoSep21.domain.Post;
import com.example.demoSep21.service.PostSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping("/posts")
@RestController
public class PostController {

    @Autowired
    PostSerivce postSerivce;

    @GetMapping
    public List<Post> getAllPosts(){
        return postSerivce.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Post> getById(@PathVariable("id") int id){
        return postSerivce.getById(id);
    }
}
