package edu.mum.cs544.Service;

import edu.mum.cs544.Domain.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();
    public User findById(Integer id);
    public User addUser(User user);
    public User updateAccountInfo(User user);
    public void deleteAccount(Integer id);
    public void updateAccountPassword(Integer id, String password);

}
