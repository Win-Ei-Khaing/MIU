package miu.main.service;

import miu.main.domain.Post;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PostService {

    public Optional<Post> findById(Long id);

    public List<Post> findAll();
}
