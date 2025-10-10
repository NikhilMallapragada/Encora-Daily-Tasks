package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String index() {
        return "index"; // Loads index.html from templates/
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Loads login.html
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin"; // Loads admin.html
    }

    @GetMapping("/user")
    public String userPage() {
        return "user"; // Loads user.html
    }

    @GetMapping("/developer")
    public String developerPage() {
        return "developer"; // Loads developer.html
    }

    @GetMapping("/validateTokenPage")
    public String validateTokenPage() {
        return "validateToken"; // Loads validateToken.html
    }

    @GetMapping("/welcome")
    public String welcomePage() {
        return "welcome"; // Loads welcome.html
    }
}
