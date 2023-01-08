package edu.mum.cs544.Service;

import java.util.List;
import edu.mum.cs544.Domain.*;

public interface CommentService {

    public List<Comment> findAll();

    public Long add(Comment comment);

    public Comment findById(long id);

    public List<Comment> findByPostId(long id);

    public void update(long id, Comment comment);

    public void delete(int id);
}
