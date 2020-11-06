package edu.school21.sockets.services;

import edu.school21.sockets.models.User;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UsersServiceImpl implements UsersService{
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsersServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public User createNewUserAccount(String name, String password) {
        // PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);
        User user1 = new User();
        user1.setId(1L);
        user1.setUsername(name);
        user1.setPassword(encodedPassword);
        return user1;
    }
}