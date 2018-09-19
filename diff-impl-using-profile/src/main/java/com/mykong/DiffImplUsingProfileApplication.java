package com.mykong;

import com.mykong.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiffImplUsingProfileApplication implements CommandLineRunner {

	@Autowired
	private WeatherService weatherService;

	public static void main(String[] args) {

		SpringApplication.run(DiffImplUsingProfileApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//weather forecast, default is sunny day!
		System.out.println(weatherService.forecast());
	}
}
