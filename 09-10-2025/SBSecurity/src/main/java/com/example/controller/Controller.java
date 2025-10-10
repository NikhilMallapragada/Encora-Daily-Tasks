package com.example.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.token.JwtUtil;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class Controller {

    @Autowired
    private JwtUtil jwtUtil;

    // Home page (just a placeholder)
    @GetMapping("/home")
    public String home() {
        return "Hello! Login via /login form to get your token.";
    }

   @GetMapping("/validateToken")
public void validateToken(@RequestParam String token, HttpServletResponse response) throws IOException {
    response.setContentType("text/html");

    if (jwtUtil.validateToken(token)) {
        String username = jwtUtil.extractUsername(token);
        String role = jwtUtil.extractUsername(token); // Extract role from token

        // Determine the redirect page based on role
        String redirectPage = "/welcome"; // default
        if ("ADMIN".equalsIgnoreCase(role)) redirectPage = "/admin";
        else if ("USER".equalsIgnoreCase(role)) redirectPage = "/user";
        else if ("DEVELOPER".equalsIgnoreCase(role)) redirectPage = "/developer";

        // Write HTML with redirect script
        response.getWriter().write(
            "<h2>Token validated!</h2>" +
            "<p>Welcome, " + username + " (" + role + ")!</p>" +
            "<p>Redirecting to your dashboard...</p>" +
            "<script>" +
            "  setTimeout(function() {" +
            "    window.location.href = '" + redirectPage + "';" +
            "  }, 1500);" + // 1.5 seconds delay to let user see message
            "</script>"
        );

    } else {
        response.getWriter().write(
            "<h2>Invalid or expired token!</h2>" +
            "<p>Please go back and enter a valid token.</p>"
        );
    }
}

}
