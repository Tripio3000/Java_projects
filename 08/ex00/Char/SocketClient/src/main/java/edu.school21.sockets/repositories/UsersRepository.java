package edu.school21.sockets.app;

// import edu.school21.sockets.models.*;

import java.util.Optional;

public interface UsersRepository extends CrudRepository {
    Optional<User> findByUsername(String username);
}