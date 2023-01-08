package miu.edu.demo.service;

import miu.edu.demo.domain.Post;
import miu.edu.demo.dto.PostDto;
import miu.edu.demo.helper.ListMapper;
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

    @Autowired
    ListMapper<Post, PostDto> listMapperPostToDto;

    @Override
    public List<PostDto> findAll() {
        return (List<PostDto>)listMapperPostToDto.mapList(postRepository.findAll(), new PostDto());
    }

    @Override
    public PostDto findById(int id) {
        return modelMapper.map(postRepository.findById(id).orElse(null), PostDto.class);
        /*Post data = postRepository.findById(id).orElse(null);
        PostDto dto = new PostDto();
        dto.setId(data.getId());
        dto.setTitle(data.getTitle());
        dto.setContent(data.getContent());
        dto.setAuthor(data.getAuthor());
        return dto;*/
    }

    @Override
    public void addPost(PostDto postDto) {
        postRepository.save(modelMapper.map(postDto, Post.class));
    }

    @Override
    public void deletePost(int id) {
        postRepository.deleteById(id);
    }

    @Override
    public void updatePost(int id, PostDto postDto) {
       postDto.setId(id);
       postRepository.save(modelMapper.map(postDto, Post.class));
    }
}
