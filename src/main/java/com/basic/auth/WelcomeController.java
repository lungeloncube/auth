package com.basic.auth;

import org.springframework.security.core.Authentication;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/greeting")
    public String greeting(Authentication authentication) {

        String userName = authentication.getName();

        return "Basic Auth - Welcome " + userName;
    }
}