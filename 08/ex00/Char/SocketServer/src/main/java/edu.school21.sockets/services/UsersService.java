package edu.school21.sockets.services;

import edu.school21.sockets.models.User;

public interface UsersService {
    public User createNewUserAccount (String password, String name);
}