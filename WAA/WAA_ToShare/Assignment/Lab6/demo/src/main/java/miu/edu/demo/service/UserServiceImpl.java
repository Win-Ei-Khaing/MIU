package miu.edu.demo.service;

import miu.edu.demo.domain.Post;
import miu.edu.demo.domain.User;
import miu.edu.demo.dto.PostDto;
import miu.edu.demo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<PostDto> getAllPostsByUserId(long id) {
        return userRepository.findById(id).getPosts()
                .stream()
                .map(p->modelMapper.map(p, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<User> findUsersWithMoreThanOnePost() {
        return userRepository.findUsersWithMoreThanOnePost();
    }

}
