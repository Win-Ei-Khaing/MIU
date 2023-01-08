package miu.edu.demo.service;

import miu.edu.demo.domain.Post;
import miu.edu.demo.dto.PostDto;
import miu.edu.demo.dto.PostV2;

import java.util.List;

public interface PostService {
    public List<PostDto> findAll();
    public PostDto findById(long id);
    public PostDto addPost(PostDto postDto);
    public PostDto deletePost(long id);
    public void updatePost(long id, PostDto postDto);
    public List<PostV2> findAllV2();
}
