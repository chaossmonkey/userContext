package com.example.usercontextdemo2;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestHeader("X-My-App-Username") String username, HttpSession session) {
        // Perform authentication (omitted for brevity)

        // Set the user context in the session
        UserContext.setCurrentUser(session, username);

        return ResponseEntity.ok("Login successful!");
    }

    @GetMapping("/hello")
    public String hello(HttpSession session) {
        String username = UserContext.getCurrentUser(session);
        System.out.println(username);
        return "Hello, " + username + "!";
    }

    @GetMapping("/random")
    public void lol(HttpSession session) {
        String random = UserContext.getCurrentUser(session);
        System.out.println(random);
    }
}


