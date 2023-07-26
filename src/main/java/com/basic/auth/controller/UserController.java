package com.basic.auth.controller;

import com.basic.auth.model.User;
import com.basic.auth.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userService.findByUsername(user.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Username already exists.");
        }
        User savedUser = userService.register(user);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/user")
    public ResponseEntity<?> getUser(Principal principal) {
        String username = principal.getName();
        User user = userService.findByUsername(username);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
//        return ResponseEntity.ok(user);
        return ResponseEntity.ok(user.getRoles() + "Login successful \n Basic Auth - Welcome  " + username);
    }

    @GetMapping("/admin/users")
    public ResponseEntity<?> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
