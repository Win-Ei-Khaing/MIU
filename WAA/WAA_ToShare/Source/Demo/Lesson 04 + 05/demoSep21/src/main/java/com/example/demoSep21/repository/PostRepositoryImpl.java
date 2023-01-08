package com.example.demoSep21.repository;

import com.example.demoSep21.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepositoryImpl implements PostRepository {

    List<Post> posts = new ArrayList<>(Arrays.asList(
            new Post(1,"Dogecoin","lots of money lost", "Nejed"),
            new Post(2,"Pizza","Very tatsy", "Johnstone")
        ));


    @Override
    public List<Post> getAll() {
        return posts;
    }

    @Override
    public Optional<Post> getById(int i){
        return
        posts.stream()
                .filter((p-> p.getId() == i))
                .findFirst();
    }
}
