package com.blog.commentmicroservice.Repository;

import java.util.List;

import com.blog.commentmicroservice.Domain.Comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository  extends JpaRepository<Comment, Long>{
   
    public Comment findById(long id);

    @Query("SELECT c FROM Comment c WHERE c.status = 1")
    public List<Comment> activeComments();

    @Query("SELECT c FROM Comment c WHERE c.postId =:id")
    public List<Comment> findByPostId(@Param("id") long postId);
}
