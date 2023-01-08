package miu.edu.lab03post.service;

import miu.edu.lab03post.domain.Post;
import miu.edu.lab03post.dto.PostDto;
import miu.edu.lab03post.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class PostServiceImpl implements PostService{

    PostRepository postRepository;
    ModelMapper modelMapper;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper){
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<PostDto> getAllPost() {
        return postRepository.findAll().stream()
                .map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDto findPostById(long id) {
        Post post = postRepository.findById(id).orElse(null);
       return modelMapper.map(post, PostDto.class);
    }

    @Override
    public void createPost(PostDto postDto) {
        Post post = modelMapper.map(postDto, Post.class);
        postRepository.save(post);
    }

    @Override
    public void deletePost(long id) {
        postRepository.deleteById(id);
    }

    @Override
    public void updatePost(long id, PostDto newPost) {
        Post post = modelMapper.map(newPost, Post.class);
        Optional<Post> postToreplace = postRepository.findById(id);
        if(postToreplace.isPresent()){
            post.setId(id);
            postRepository.save(post);
        }
    }


}
