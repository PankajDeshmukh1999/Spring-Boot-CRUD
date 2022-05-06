package com.csi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
public class SpringBootJpaEmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaEmployeeApplication.class, args);
	}
}
