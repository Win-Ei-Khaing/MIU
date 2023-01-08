package edu.mum.cs544.Service;

import java.net.URI;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import edu.mum.cs544.Domain.Post;

@Service
public class PostServiceProxy implements PostService{
    private final String postUrl = "http://localhost:8080/posts/{id}"; 
    private final String postsUrl = "http://localhost:8080/posts/";
    private final String postsByTitleUrl="http://localhost:8080/postsByTitle?title=";

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
    public List<Post> findAll() {
       ResponseEntity<List<Post>> response = getRestTemplate().exchange(postsUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Post>>(){});//new HttpEntity<Object>(createHeaders(userName, password))
       return response.getBody();
    }

    @Override
    public Post findById(long id) {
        return getRestTemplate().getForObject(postUrl, Post.class, id);
    }

    @Override
    public List<Post> findByTitle(String title) {
       ResponseEntity<List<Post>> response = getRestTemplate().exchange(postsByTitleUrl+title, HttpMethod.GET, null, new ParameterizedTypeReference<List<Post>>(){});
       return response.getBody();
    }
    
    @Override
    public Long add(Post post) {
        URI uri = getRestTemplate().postForLocation(postsUrl, post);
        if (uri == null) { return null; }
        Matcher m = Pattern.compile(".*/posts/(\\d+)").matcher(uri.getPath()); 
        m.matches();
        return Long.parseLong(m.group(1));
    }

    @Override
    public void update(long id, Post post) {
        getRestTemplate().put(postUrl, post, id);
    }

    @Override
    public void delete(long id) {
        getRestTemplate().delete(postUrl, id);
    }

    
}
