package edu.mum.cs544.Service;

import edu.mum.cs544.Domain.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Service
public class UserServiceProxy implements UserService{
    private final String userUrl1 = "http://localhost:8088/users/{id}";
    private final String userUrl2 = "http://localhost:8088/users/";
    private final String userUrl3 = "http://localhost:8088/accounts/";
    private final String userUrl4 = "http://localhost:8088/accounts/{id}";
    private final String userUrl5 = "http://localhost:8088/accounts/{id}/{password}";

    private RestTemplate getRestTemplate() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        RestTemplate restTemplate = new RestTemplate();

        if(authentication != null){
            String password="";
            switch(authentication.getName()){
                case("admin"): password ="Group12Admin"; break;
                case("user"): password ="Group12User"; break;
                case("blogger"): password ="Group12Blogger";break;
            }

            restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(authentication.getName(), password));
        }
        return restTemplate;
    }


    @Override
    public List<User> findAll() {
        ResponseEntity<List<User>> response = getRestTemplate().exchange(userUrl2, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {});
        return response.getBody();
    }

    @Override
    public User findById(Integer id) {
        return getRestTemplate().getForObject(userUrl1, User.class, id);
    }

    @Override
    public User addUser(User user) {
        URI uri = getRestTemplate().postForLocation(userUrl2, user);
        if (uri == null) { return null; }
        // Matcher m = Pattern.compile(".*/users/(\\d+)").matcher(uri.getPath());
        // m.matches();
        return user;
    }

    @Override
    public User updateAccountInfo(User user) {
        getRestTemplate().put(userUrl3, user);
        return user;
    }

    @Override
    public void deleteAccount(Integer id) {
        getRestTemplate().delete(userUrl4, id);
    }

    @Override
    public void updateAccountPassword(Integer id, String password) {
        getRestTemplate().put(userUrl5, id, password);
    }
}
