package edu.school21.sockets.app;

// import edu.school21.sockets.models.*;

import java.util.*;

public interface CrudRepository {
    Optional<User> findById(Long id);
    List<User> findAll();
    void save(User entity);
    void update(User entity);
    void delete(Long id);
}