package  edu.mum.cs544.Service;

import  edu.mum.cs544.Domain.User;
import  edu.mum.cs544.Dto.UserResponse;
import  edu.mum.cs544.Repository.UserRepository;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Secured({"ROLE_ADMIN", "ROLE_BLOGGER", "ROLE_USER"})
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<UserResponse> findAll() {
        List<User> userEntityList = userRepository.findAll();

        Type listType = new TypeToken<List<UserResponse>>(){}.getType();
        List<UserResponse> usersDto = modelMapper.map(userEntityList,listType);

        return usersDto;
    }

    @Override
    public UserResponse findById(Integer id) {
        User user = userRepository.findById(id).get();
        return modelMapper.map(user, UserResponse.class);
    }

    @Override
    public User addUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User updateAccountInfo(User user) {
        User userToUpdate = userRepository.findById(user.getId()).get();
        userToUpdate = user;
        userRepository.save(userToUpdate);

        return user;
    }

    @Override
    public void updateAccountPassword(Integer id, String password ) {
        User user = userRepository.findById(id).get();
        user.setPassword(password);
        updateAccountInfo(user);
    }

    @Override
    public void deleteAccount(Integer id) {
        User user =  userRepository.findById(id).get();
        user.setStatus(false);
        updateAccountInfo(user);
    }


}
