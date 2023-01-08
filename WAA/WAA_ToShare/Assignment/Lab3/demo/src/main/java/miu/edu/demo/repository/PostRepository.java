package miu.edu.demo.repository;

import miu.edu.demo.domain.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    public List<Post> findAll();
    public Optional<Post> findById(int id);
    public void addPost(Post post);
    public void deletePost(int id);
}
