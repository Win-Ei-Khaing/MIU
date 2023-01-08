package edu.mum.cs544.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import edu.mum.cs544.Domain.Comment;
import edu.mum.cs544.Domain.Post;
import edu.mum.cs544.Domain.User;
import edu.mum.cs544.Service.CommentService;
import edu.mum.cs544.Service.PostService;
import edu.mum.cs544.Service.UserService;


@RestController
@RequestMapping("/blog")
public class BlogRestController {
    @Autowired
    PostService postService;

    @Autowired
    CommentService commentService;

    @Autowired
    UserService userService;

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

    // ----------------------------------- COMMENT ---------------------------------- //

    @GetMapping("/comments")
    public ResponseEntity<List<Comment>> getAllComment() {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(commentService.findAll());
        }
        catch(Forbidden ex) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
    }
    

    @GetMapping("/comments/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(commentService.findById(id));
        }
        catch(Forbidden ex){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
    }

    @GetMapping("commentsByPost/{postId}")
    public ResponseEntity<List<Comment>> getByPost(@PathVariable long postId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(commentService.findByPostId(postId));
        }
        catch (Forbidden ex) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
    }

    @PostMapping("/comments")
    public ResponseEntity<String> addComment(@RequestBody Comment comment) {
        try {
            commentService.add(comment);
            return ResponseEntity.status(HttpStatus.CREATED).body("Comment successfully created.");
        }
        catch(Forbidden ex) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Not allowed");
        }

        catch(IllegalStateException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Data is not valid");
        }
    }

    @PutMapping("/comments/{id}")
    public ResponseEntity<String> updateComment(@PathVariable int id, @RequestBody Comment comment) {
        try {
            commentService.update(id, comment);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Comment updated");
        }

        catch(Forbidden ex) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Not allowed");
        }
        catch(HttpClientErrorException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable int id) {
        try {
            commentService.delete(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Comment deleted");
        }

        catch(Forbidden ex) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Not allowed");
        }
    }

    // ----------------------------------- USER ---------------------------------- //

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
        }
        catch(HttpClientErrorException.Forbidden ex){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
    }


    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id));
        }
        catch(HttpClientErrorException.Forbidden ex){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        try{
            userService.addUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("User was successfully created");
        }
        catch(HttpClientErrorException.Forbidden ex){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("This method is forbidden for this authentication");
        }
        catch(IllegalStateException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please check user data to add again");
        }
    }


    @PutMapping("/accounts")
    public ResponseEntity<String> updateAccountInfo(@RequestBody User user) {
        try{
            userService.updateAccountInfo(user);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Account Information has been successfully updated");
        }
        catch(HttpClientErrorException.Forbidden ex){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("This method is forbidden for this authentication");
        }
        catch(HttpClientErrorException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }


    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<String>  deleteAccount(@PathVariable Integer id) {
        try{
            userService.deleteAccount(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("User Account was successfully deleted");
        }
        catch(HttpClientErrorException.Forbidden ex){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("This method is forbidden for this authentication");
        }
    }



    @PutMapping("/accounts/{id}/{password}")
    public ResponseEntity<String>  updateAccountPassowrd(@PathVariable Integer id, @PathVariable String password) {
        try{
            userService.updateAccountPassword(id,password);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Account Passoword successfully Changed");
        }
        catch(HttpClientErrorException.Forbidden ex){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("This method is forbidden for this authentication");
        }
    }
}
