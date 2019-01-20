package com.practice.jpa.springbootjpahibgrdl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.practice.jpa.springbootjpahibgrdl.repository")
@SpringBootApplication
public class SpringbootJpaHibGrdlApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaHibGrdlApplication.class, args);
	}
}
