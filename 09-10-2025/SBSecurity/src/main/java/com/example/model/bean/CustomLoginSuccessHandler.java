package com.example.model.bean;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.example.token.JwtUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        String username = authentication.getName();
        String role = authentication.getAuthorities().iterator().next().getAuthority();

        // Generate 5-minute expiry token
        String token = jwtUtil.generateToken(username, 5);
        System.out.println("Generated JWT token for " + username + ": " + token);

        // Greet user/admin and provide space to validate token
        String greeting = role.equals("ROLE_ADMIN") ? "Welcome Admin!" : "Welcome User!";

        response.setContentType("text/html");
        response.getWriter().write(
            "<!DOCTYPE html>" +
            "<html>" +
            "<head>" +
            "  <title>Token Validation</title>" +
            "  <style>" +
            "    body { " +
            "      font-family: Arial, sans-serif; " +
            "      background: linear-gradient(135deg, #74ebd5, #ACB6E5); " + // gradient background
            "      display: flex; justify-content: center; align-items: center; height: 100vh; " +
            "      margin: 0; " +
            "    }" +
            "    .container { " +
            "      background: linear-gradient(145deg, #ffffff, #e0e0e0); " + // subtle container gradient
            "      padding: 40px; border-radius: 15px; box-shadow: 0 8px 25px rgba(0,0,0,0.2); text-align: center; " +
            "      max-width: 600px; width: 90%; " +
            "    }" +
            "    h2 { color: #333; margin-bottom: 20px; }" +
            "    p { color: #555; margin-bottom: 15px; }" +
            "    input { " +
            "      width: 80%; padding: 12px; margin: 15px 0; border-radius: 8px; border: 1px solid #ccc; font-size: 16px; " +
            "      outline: none; " +
            "    }" +
            "    input:focus { border-color: #007bff; box-shadow: 0 0 5px #007bff; }" +
            "    button { " +
            "      padding: 12px 30px; font-size: 16px; border: none; border-radius: 8px; " +
            "      background: linear-gradient(90deg, #007bff, #00d4ff); color: white; cursor: pointer; transition: all 0.3s; " +
            "    }" +
            "    button:hover { background: linear-gradient(90deg, #0056b3, #00a3cc); transform: scale(1.05); }" +
            "  </style>" +
            "</head>" +
            "<body>" +
            "  <div class='container'>" +
            "    <h2>" + greeting + "</h2>" +
            "    <p>Check Eclipse console for your token.</p>" +
            "    <p>Paste your token below for validation:</p>" +
            "    <input type='text' id='tokenInput' placeholder='Enter token here'>" +
            "    <br>" +
            "    <button onclick='validateToken()'>Validate Token</button>" +
            "  </div>" +
            "  <script>" +
            "    function validateToken() {" +
            "      const token = document.getElementById('tokenInput').value.trim();" +
            "      if(token) {" +
            "        window.location.href = '/validateToken?token=' + token;" +
            "      } else {" +
            "        alert('Please enter a token before validating.');" +
            "      }" +
            "    }" +
            "  </script>" +
            "</body>" +
            "</html>"
        );


    }
}
