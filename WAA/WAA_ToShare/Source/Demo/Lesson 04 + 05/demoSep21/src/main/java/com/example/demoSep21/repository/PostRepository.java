package com.example.demoSep21.repository;


import com.example.demoSep21.domain.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {

    public List<Post> getAll();

    public Optional<Post> getById( int id);
}
