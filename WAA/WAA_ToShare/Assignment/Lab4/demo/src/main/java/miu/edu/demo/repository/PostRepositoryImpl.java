package miu.edu.demo.repository;

import miu.edu.demo.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepositoryImpl implements PostRepository{

    List<Post> posts = new ArrayList<>(
            Arrays.asList(
                    new Post(1, "Thanksgiving day", "We got one day off. It's so enjoyable", "Win"),
                    new Post(2, "Winter break", "We will get almost one month break after WAA course", "Ei")
                    ));

    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public Optional<Post> findById(int id) {
        return posts.stream().filter(p -> p.getId() == id).findFirst();
    }

    @Override
    public void addPost(Post post) {
        posts.add(post);
    }

    @Override
    public void deletePost(int id) {
        for(Post p: posts){
            if(p.getId() == id){
                posts.remove(p);
                break;
            }        }
    }

    @Override
    public void updatePost(int id, Post post) {
        for(Post p: posts){
            if(p.getId() == id){
                p.setId(post.getId());
                p.setTitle(post.getTitle());
                p.setContent(post.getContent());
                p.setAuthor(post.getAuthor());
                break;
            }
        }
    }
}
