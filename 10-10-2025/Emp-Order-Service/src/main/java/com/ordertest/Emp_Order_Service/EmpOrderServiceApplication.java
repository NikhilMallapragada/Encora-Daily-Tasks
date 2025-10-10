package com.ordertest.Emp_Order_Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = "package com.ordertest.Controller")
public class EmpOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpOrderServiceApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
