package edu.mum.cs544.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpClientErrorException.Forbidden;

import edu.mum.cs544.Domain.Post;
import edu.mum.cs544.Service.PostService;

@RestController
@RequestMapping("/blog")
public class BlogRestController {
    @Autowired
    PostService postService;

    @GetMapping(value="/posts")
    public ResponseEntity<List<Post>> getAll() {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(postService.findAll());
        }
        catch(Forbidden ex){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
    }
       
    @GetMapping(value= "/posts/{id}")
    public ResponseEntity<Post> getById(@PathVariable int id) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(postService.findById(id));
        }
        catch(Forbidden ex){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
    }

    @GetMapping(value= "/postsByTitle")
    public ResponseEntity<List<Post>> getByTitle(@RequestParam String title) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(postService.findByTitle(title));
        }
        catch(Forbidden ex){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
    }
    
    @PostMapping(value="/posts")
    public ResponseEntity<String>  add(@RequestBody Post post) {
        try{
            Long createdID = postService.add(post);
            return ResponseEntity.status(HttpStatus.CREATED).body("Post was successfully created with ID - "+createdID);
        }
        catch(Forbidden ex){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("This method is forbidden for this authentication");
        }
        catch(IllegalStateException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please check Post data to add again");
        }
    }

     @PutMapping(value= "/posts/{id}")
     public ResponseEntity<String>   update(@PathVariable int id, @RequestBody Post post) {
        try{
            postService.update(id, post);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Post was successfully updated");
        }
        catch(Forbidden ex){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("This method is forbidden for this authentication");
        }
        catch(HttpClientErrorException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
     }

    @DeleteMapping(value="/posts/{id}")
    public ResponseEntity<String>  delete(@PathVariable int id) {
        try{
            postService.delete(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Post was successfully deleted");
        }
        catch(Forbidden ex){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("This method is forbidden for this authentication");
        }
    }
}
