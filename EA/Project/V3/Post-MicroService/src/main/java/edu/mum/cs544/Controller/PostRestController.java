package edu.mum.cs544.Controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.coyote.http11.HttpOutputBuffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import edu.mum.cs544.Domain.Post;
import edu.mum.cs544.Service.PostService;

@RestController
public class PostRestController {
    @Autowired
    PostService postService;

    @GetMapping(value="/posts")
    public List<Post> getAll() {
        return postService.findAll();
    }
       
    @GetMapping(value= "/posts/{id}")
    public Post getById(@PathVariable int id) {
        return postService.findById(id);
    }

    @GetMapping(value= "/postsByTitle")
    public List<Post> getByTitle(@RequestParam String title) {
        return postService.findByTitle(title);
    }
    
    @PostMapping(value="/posts")
    public RedirectView add(@RequestBody @Valid Post post, BindingResult result) {
        if(!result.hasErrors()){
            postService.add(post);
        }
        System.out.println(post.getId());
        return new RedirectView("/posts/" + post.getId());
    }

    @PutMapping(value= "/posts/{id}")
    public ResponseEntity<String>  update(@PathVariable int id, @RequestBody @Valid Post post, BindingResult result) {
        if (post!=null) 
        {

            if(result.hasErrors())
                throw new IllegalArgumentException();
            
            if(id != post.getId())
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Parameter ID and Post's ID mush be the same");
            else{
                if(getById(id) == null)
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There is no post with that ID - "+id+" to update");
                Boolean status=getById(id).getStatus();
                if(!status)
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Deleted post are not allowed to update");
            }
        }
            postService.update(post);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Post was successfully updated");
    }

    @DeleteMapping(value="/posts/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        if(getById(id) == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There is no post with that ID - "+id+" to delete");
        postService.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Post was successfully deleted");
    }
}
