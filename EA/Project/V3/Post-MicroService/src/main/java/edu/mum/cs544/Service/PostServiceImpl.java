package edu.mum.cs544.Service;

import edu.mum.cs544.Domain.Post;
import edu.mum.cs544.Repository.PostRepository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Secured({ "ROLE_ADMIN", "ROLE_BLOGGER", "ROLE_USER"})
public class PostServiceImpl implements PostService{
    @Autowired
    PostRepository postRepository;

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }
    
    @Override
    public Post findById(long id) {
        return postRepository.findById(id);
    }

    @Override
    public List<Post> findByTitle(String title){
        return postRepository.findByTitle(title);
    }

    @Secured({ "ROLE_ADMIN", "ROLE_BLOGGER"})
    @Override
    public void add(Post post) {
       post.setStatus(true); //as only deletion will set it true
       post.setPostedOn(LocalDateTime.now()); //set the current time

       postRepository.save(post);
    }

    @Secured({ "ROLE_ADMIN", "ROLE_BLOGGER"})
    @Override
    public void update(Post post) {
       post.setStatus(true); //as only deletion will set it true
       post.setPostedOn(LocalDateTime.now());

       postRepository.save(post);
        
    }

    @Secured({ "ROLE_ADMIN", "ROLE_BLOGGER"})
    @Override
    public void delete(long id) {
        //as we change only status flag from ture to false at deletion
        Post postToDelete = findById(id);
        postToDelete.setStatus(false);

        postRepository.deleteById(id);
    }

    
}
