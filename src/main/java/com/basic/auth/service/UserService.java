package com.basic.auth.service;

import com.basic.auth.model.User;

import java.util.List;

public interface UserService {
    User register(User user);
    User findByUsername(String username);

    List<User> getAllUsers();
}
