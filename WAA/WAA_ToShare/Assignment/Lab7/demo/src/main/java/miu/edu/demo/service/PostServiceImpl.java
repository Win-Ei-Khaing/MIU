package miu.edu.demo.service;

import miu.edu.demo.domain.Post;
import miu.edu.demo.dto.PostDto;
import miu.edu.demo.dto.PostV2;
import miu.edu.demo.dto.UserDto;
import miu.edu.demo.repository.PostRepository;
import miu.edu.demo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<PostDto> findAll() {
        List<PostDto> result = new ArrayList<PostDto>();
        for(Post p : postRepository.findAll()){
            PostDto postDto = new PostDto();
            postDto.setId(p.getId());
            postDto.setTitle(p.getTitle());
            postDto.setContent(p.getContent());
            postDto.setAuthor(p.getAuthor());
            postDto.setUser(modelMapper.map(p.getUser(), UserDto.class));
            result.add(postDto);
        }
        return result;
    }

    @Override
    public PostDto findById(long id) {
        /*Post data = postRepository.findById(id).orElse(null);
        PostDto dto = new PostDto();
        dto.setId(data.getId());
        dto.setTitle(data.getTitle());
        dto.setContent(data.getContent());
        dto.setAuthor(data.getContent());
        return dto;*/
        return modelMapper.map(postRepository.findById(id).orElse(null), PostDto.class);
    }

    @Override
    public PostDto addPost(PostDto postDto) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        String userName = userDetails.getUsername();
        Post newPost = modelMapper.map(postDto, Post.class);
        newPost.setUser(userRepository.findByUsername(userName).get());
        postRepository.save(newPost);

        postDto.setId(newPost.getId());
        postDto.setUser(modelMapper.map(newPost.getUser(), UserDto.class));
        return postDto;
    }

    @Override
    public PostDto deletePost(long id) {
        PostDto deletedDto = modelMapper.map(postRepository.findById(id), PostDto.class);
        postRepository.deleteById(id);
        return deletedDto;
    }

    @Override
    public void updatePost(long id, PostDto postDto) {
        Post post = modelMapper.map(postDto, Post.class);
        post.setId(id);
        postRepository.save(post);
    }

    @Override
    public List<PostV2> findAllV2() {
        return postRepository.findAll().stream().map(p->modelMapper.map(p, PostV2.class)).collect(Collectors.toList());
    }
}
