package edu.mum.cs544.Service;

import edu.mum.cs544.Domain.Post;

import java.util.List;

public interface PostService {

    public List<Post> findAll();

    public Post findById(long id);

    public List<Post> findByTitle(String title);

    public Long add(Post post);

    public void update(long id, Post post);

    public void delete(long id);

}
