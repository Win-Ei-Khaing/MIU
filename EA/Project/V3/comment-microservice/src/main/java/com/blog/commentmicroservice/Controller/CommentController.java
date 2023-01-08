package com.blog.commentmicroservice.Controller;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.view.RedirectView;

import com.blog.commentmicroservice.Domain.*;
import com.blog.commentmicroservice.Service.*;

@RestController
public class CommentController {
    @Autowired
    CommentService commentService;

    // @GetMapping("/")
    // public RedirectView redirectRoot() {
    //     return new RedirectView("/comments");
    // }

    @GetMapping("/comments")
    public List<Comment> getAll() {
        return commentService.findAll();
    }

    @GetMapping("/comments/{id}")
    public Comment get(@PathVariable long id){
       return commentService.findById(id);     
    }

    @GetMapping("/commentsByPost/{postId}")
    public List<Comment> getByPost(@PathVariable long postId){
       return commentService.findByPostId(postId);     
    }


    @PostMapping("/comments")
    public ResponseEntity<String> add(@RequestBody @Valid Comment comment, BindingResult result){
        if(!result.hasErrors()){
            commentService.add(comment);
            return ResponseEntity.status(HttpStatus.CREATED).body("Comment saved -- " + comment.getId());
        }
        return ResponseEntity.badRequest().body("Comment Not Saved -- " + result);
    }

    @PutMapping("/comments/{id}")
    public ResponseEntity<String> update(@PathVariable long id, @RequestBody Comment comment) {
        if(comment!=null){
            if(id!=comment.getId()){
                throw new IllegalArgumentException();
            }
            else {
                Boolean commentStatus = get(id).getStatus();
                if(!commentStatus){
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Comment status is inactive");
                }
            }
        }

        commentService.update(comment);
        return ResponseEntity.accepted().body("Comment successfully updated");
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        commentService.delete(id);
        return ResponseEntity.accepted().body("Comment deleted");
    }
}
