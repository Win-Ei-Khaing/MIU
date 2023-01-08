package miu.edu.demo.service;

import miu.edu.demo.domain.Post;
import miu.edu.demo.dto.PostDto;

import java.util.List;

public interface PostService {
    public List<Post> findAll();
    public PostDto findById(int id);
    public void addPost(Post post);
    public void deletePost(int id);
}
