package com.basic.auth.controller;

import com.basic.auth.model.User;
import com.basic.auth.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User registeredUser = userService.register(user);
        return ResponseEntity.ok(registeredUser);
    }

    @GetMapping("/users/{username}")
    public ResponseEntity<String> getUserByUsername(@PathVariable String username) {
        User user = userService.findByUsername(username);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
//        return ResponseEntity.ok(user);
        return ResponseEntity.ok("Login successful \n Basic Auth - Welcome " + username);
    }
}
