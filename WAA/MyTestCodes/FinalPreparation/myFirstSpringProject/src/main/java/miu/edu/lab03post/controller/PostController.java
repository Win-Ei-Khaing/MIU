package miu.edu.lab03post.controller;

import miu.edu.lab03post.domain.Post;
import miu.edu.lab03post.dto.PostDto;
import miu.edu.lab03post.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/posts")
@RestController
@CrossOrigin("http://localhost:3000/")
public class PostController {
    private PostService postService;
    private ModelMapper modelMapper;

    @Autowired
    public PostController(PostService postService, ModelMapper modelMapper) {
        this.postService = postService;
        this.modelMapper = modelMapper;
    }

    @GetMapping()
    public List<PostDto> getAllPost() {
        return postService.getAllPost();
    }

    @GetMapping("/{id}")
    public PostDto findPostById(@PathVariable("id") long postId){
        return postService.findPostById(postId);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestBody PostDto post) {
        postService.createPost(post);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void deletePost(@PathVariable("id") long postId) {
        postService.deletePost(postId);
    }


    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updatePost(@PathVariable("id") long postId, @RequestBody PostDto postDto) {
        postService.updatePost(postId, postDto);
    }


}
