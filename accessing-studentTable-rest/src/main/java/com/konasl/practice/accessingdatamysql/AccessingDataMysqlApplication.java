package com.konasl.practice.accessingdatamysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AccessingDataMysqlApplication {

	public static void main(String[] args) {

		SpringApplication.run(AccessingDataMysqlApplication.class, args);
	}
}
