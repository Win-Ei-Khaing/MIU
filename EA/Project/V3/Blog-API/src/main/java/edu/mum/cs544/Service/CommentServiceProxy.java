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

import edu.mum.cs544.Domain.Comment;

@Service
//@RequestMapping("/blog")
public class CommentServiceProxy implements CommentService{

    // API URLs
    private String commentsServiceUrl = "http://localhost:8082/comments/";
    private String commentServiceUrl = "http://localhost:8082/comments/{id}";
    private String commentsByPostUrl = "http://localhost:8082/commentsByPost/{postId}";

    private RestTemplate getRestTemplate() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        RestTemplate restTemplate = new RestTemplate(); 

        if(authentication != null){
            String password="";
            switch(authentication.getName()){
                case("admin"): 
                    password ="Group12Admin"; 
                    break; 
                case("user"): 
                    password ="Group12User"; 
                    break;
                case("blogger"): 
                    password ="Group12Blogger";
                    break;
            }

            restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(authentication.getName(), password));
        }
        return restTemplate;
    }


    @Override
    public List<Comment> findAll() {
        ResponseEntity<List<Comment>> response = getRestTemplate().exchange(commentsServiceUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Comment>>(){});
        return response.getBody();
    }

    @Override
    public Long add(Comment comment) {
        URI uri = getRestTemplate().postForLocation(commentsServiceUrl, comment);
        if(uri == null) {
            return null;
        }
        Matcher m = Pattern.compile(".*/comments/(\\d+)").matcher(uri.getPath());
        m.matches();
        return Long.parseLong(m.group(1));
        
    }

    @Override
    public Comment findById(long id) {
        return getRestTemplate().getForObject(commentServiceUrl, Comment.class, id);
    }

    @Override
    public List<Comment> findByPostId(long postId) {
        ResponseEntity<List<Comment>> response = getRestTemplate().exchange(commentsByPostUrl+postId, HttpMethod.GET, null, new ParameterizedTypeReference<List<Comment>>() {});
        return response.getBody();
    }

    @Override
    public void update(long id, Comment comment) {
        getRestTemplate().put(commentServiceUrl, comment, id);
        
    }

    @Override
    public void delete(int id) {
        getRestTemplate().delete(commentServiceUrl, id);
        
    }
    
}
