package com.example.model.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.token.JwtUtil;

@Configuration
public class JwtConfig {

	@Bean
	public JwtUtil jwtUtil() {
		return new JwtUtil();
	}
}
