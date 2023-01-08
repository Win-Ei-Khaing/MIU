package miu.edu.demo.service;

import miu.edu.demo.domain.Post;
import miu.edu.demo.dto.PostDto;
import miu.edu.demo.dto.PostV2;
import miu.edu.demo.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<PostDto> findAll() {
        return postRepository.findAll().stream().map(p->modelMapper.map(p, PostDto.class)).collect(Collectors.toList());
    }

    @Override
    public PostDto findById(int id) {
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
        postRepository.addPost(modelMapper.map(postDto, Post.class));
        return postDto;
    }

    @Override
    public PostDto deletePost(int id) {
        PostDto deletedDto = modelMapper.map(postRepository.findById(id), PostDto.class);
        postRepository.deletePost(id);
        return deletedDto;
    }

    @Override
    public void updatePost(int id, PostDto postDto) {
        postRepository.updatePost(id, modelMapper.map(postDto, Post.class));
    }

    @Override
    public List<PostV2> findAllV2() {
        return postRepository.findAll().stream().map(p->modelMapper.map(p, PostV2.class)).collect(Collectors.toList());
    }
}
