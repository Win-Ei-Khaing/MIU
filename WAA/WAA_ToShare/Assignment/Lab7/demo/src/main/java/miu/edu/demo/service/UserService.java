package miu.edu.demo.service;

import miu.edu.demo.domain.Post;
import miu.edu.demo.domain.User;
import miu.edu.demo.dto.PostDto;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public User findById(long id);
    public void createUser(User user);
    public List<PostDto> getAllPostsByUserId(long id);
    public List<User> findUsersWithMoreThanOnePost();
}
