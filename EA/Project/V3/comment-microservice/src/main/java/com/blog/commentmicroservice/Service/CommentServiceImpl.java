package com.blog.commentmicroservice.Service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import com.blog.commentmicroservice.Repository.CommentRepository;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import com.blog.commentmicroservice.Domain.Comment;

@Service
@Transactional
@Secured({ "ROLE_ADMIN", "ROLE_BLOGGER", "ROLE_USER"})
public class CommentServiceImpl implements CommentService{
    
    @Resource
    CommentRepository commentRepository;

    @Override
    public List<Comment> findAll() {
        return commentRepository.activeComments();
    }

    @Override
    public void add(Comment comment) {
        comment.setStatus(true);
        commentRepository.save(comment);
        
    }

    @Override
    public Comment findById(long id) {
        return commentRepository.findById(id);
        
    }

    @Override
    public void update(Comment comment) {
        comment.setStatus(true);
        commentRepository.save(comment);
        
    }

    @Override
    public void delete(Long id) {
        Comment deleteComment = findById(id);
        deleteComment.setStatus(false);
        commentRepository.save(deleteComment);
        
    }

    @Override
    public List<Comment> findByPostId(long id) {
        return commentRepository.findByPostId(id);
    }

    
}
