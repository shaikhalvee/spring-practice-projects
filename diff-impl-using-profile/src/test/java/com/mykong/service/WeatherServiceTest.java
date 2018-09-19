package com.mykong.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("raining")
public class WeatherServiceTest {

	@Autowired
	WeatherService weatherService;

	@Test
	public void testRainingProfile() throws Exception {
		String output = weatherService.forecast();
		assertThat(output).contains("Today is a rainy day!!");
	}
}