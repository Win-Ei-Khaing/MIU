package com.example.demoSep21.service;


import com.example.demoSep21.domain.Post;

import java.util.List;
import java.util.Optional;

public interface PostSerivce {

    public List<Post> getAll();

    public Optional<Post> getById(int id);
}
