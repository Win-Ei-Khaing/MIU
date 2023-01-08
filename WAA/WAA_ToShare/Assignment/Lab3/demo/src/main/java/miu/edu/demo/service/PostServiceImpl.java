package miu.edu.demo.service;

import miu.edu.demo.domain.Post;
import miu.edu.demo.dto.PostDto;
import miu.edu.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public PostDto findById(int id) {
        Post data = postRepository.findById(id).orElse(null);
        PostDto dto = new PostDto();
        dto.setId(data.getId());
        dto.setTitle(data.getTitle());
        dto.setContent(data.getContent());
        dto.setAuthor(data.getContent());
        return dto;
    }

    @Override
    public void addPost(Post post) {
        postRepository.addPost(post);
    }

    @Override
    public void deletePost(int id) {
        postRepository.deletePost(id);
    }
}
