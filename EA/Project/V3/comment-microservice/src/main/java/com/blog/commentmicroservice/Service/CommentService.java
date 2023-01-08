package com.blog.commentmicroservice.Service;

import java.util.List;
import com.blog.commentmicroservice.Domain.*;

public interface CommentService {

    public List<Comment> findAll();

    public void add(Comment comment);

    public Comment findById(long id);

    public List<Comment> findByPostId(long id);

    public void update(Comment comment);

    public void delete(Long id);
}
