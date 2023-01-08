package edu.mum.cs544.Service;

import edu.mum.cs544.Domain.Post;

import java.util.List;

public interface PostService {

    public List<Post> findAll();

    public Post findById(long id);

    public List<Post> findByTitle(String title);

    public void add(Post book);

    public void update(Post book);

    public void delete(long id);

}
