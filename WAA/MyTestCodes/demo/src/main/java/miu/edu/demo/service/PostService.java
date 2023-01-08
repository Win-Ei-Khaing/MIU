package miu.edu.demo.service;

import miu.edu.demo.domain.Post;
import miu.edu.demo.dto.PostDto;

import java.util.List;

public interface PostService {
    public List<PostDto> findAll();
    public PostDto findById(int id);
    public void addPost(PostDto postDto);
    public void deletePost(int id);
    public void updatePost(int id, PostDto postDto);
}
