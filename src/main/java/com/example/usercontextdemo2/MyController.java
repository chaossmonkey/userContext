package com.example.usercontextdemo2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/hello")
    public String hello() {
        String username = UserContext.getCurrentUser();
        System.out.println(username);
        return "Hello, " + username + "!";
    }
}
