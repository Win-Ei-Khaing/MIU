package miu.edu.lab03post.service;

import miu.edu.lab03post.domain.Post;
import miu.edu.lab03post.dto.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> getAllPost();
    PostDto findPostById(long id);
    void createPost(PostDto post);
    void deletePost(long id);
    void updatePost(long id, PostDto newPost);
}
