package miu.edu.demo.repository;

import miu.edu.demo.domain.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends CrudRepository<Post, Integer> {
    public List<Post> findAll();
    public Optional<Post> findById(int id);
}
