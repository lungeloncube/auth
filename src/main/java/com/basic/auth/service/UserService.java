package com.basic.auth.service;

import com.basic.auth.model.User;

public interface UserService {
    User register(User user);
    User findByUsername(String username);
}
