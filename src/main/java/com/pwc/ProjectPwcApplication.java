package com.pwc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.pwc.entity")
public class ProjectPwcApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectPwcApplication.class, args);
	}

}
