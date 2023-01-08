package miu.edu.demo.repository;

import miu.edu.demo.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    public List<User> findAll();

    @Query(value = "SELECT * FROM USER u WHERE u.ID=:id", nativeQuery = true)
    public User findById(@Param("id") long userId);

    @Query(value = "SELECT u FROM User u WHERE u.posts.size > 1")
     //@Query(value = "SELECT u.* FROM USER u WHERE (SELECT COUNT(p.*) FROM POST p WHERE p.USER_ID=u.ID)>1", nativeQuery = true)
    public List<User> findUsersWithMoreThanOnePost();

    public Optional<User> findByUsername(String userName);
}
