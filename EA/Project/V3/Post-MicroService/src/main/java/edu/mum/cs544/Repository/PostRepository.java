package edu.mum.cs544.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs544.Domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

    @Query("SELECT p FROM Post p WHERE p.status = 1")//filtering the posts with status FALSE
    public List<Post> findAllAlivePosts();

    public Post findById(long id);

    @Query("SELECT p FROM Post p WHERE p.title LIKE %:title% AND p.status = 1")
    public List<Post> findByTitle(String title);
}
