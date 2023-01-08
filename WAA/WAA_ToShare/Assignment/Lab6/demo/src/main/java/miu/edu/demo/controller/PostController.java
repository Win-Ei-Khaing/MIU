package miu.edu.demo.controller;

import miu.edu.demo.domain.Post;
import miu.edu.demo.dto.Greeting;
import miu.edu.demo.dto.PostDto;
import miu.edu.demo.dto.PostV2;
import miu.edu.demo.dto.PostWithLinks;
import miu.edu.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping
    public List<PostDto> getAll(){
        return postService.findAll();
    }

    @GetMapping("/hello")
    public HttpEntity<Greeting> getHello(){
        Greeting greeting = new Greeting("Hello World");
        greeting.add(linkTo(methodOn(PostController.class).getHello()).withSelfRel());

        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<PostWithLinks> getById(@PathVariable("id") int id){
        PostDto postResult = postService.findById(id);
        PostWithLinks postWithLinks = new PostWithLinks(postResult);
        postWithLinks.add(linkTo(methodOn(PostController.class).addPost(postResult))
                .withSelfRel().withType("POST"));
        postWithLinks.add(linkTo(methodOn(PostController.class).deletePost(id))
                .withSelfRel().withType("DELETE"));
        return new ResponseEntity<>(postWithLinks, HttpStatus.OK);
    }

    /*@GetMapping("/{id}")
    public EntityModel<PostDto> getById(@PathVariable("id") int id){
        PostDto post = postService.findById(id);
        EntityModel<PostDto> resource = EntityModel.of(post);
        WebMvcLinkBuilder linkTo = WebMvcConfigurer.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAll());
        resource.add(linkTo.withRel("all-posts"));
        return resource;
    }*/

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostDto addPost(@RequestBody PostDto postDto) {
        return postService.addPost(postDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public PostDto deletePost(@PathVariable int id){
        return postService.deletePost(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePost(@PathVariable int id, @RequestBody PostDto postDto){
        postService.updatePost(id, postDto);
    }

    @GetMapping("/v2")
    public List<PostV2> getAllV2(){
        return postService.findAllV2();
    }
}
