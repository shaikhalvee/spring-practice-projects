package com.mykong.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("rainy")
public class RainyDayService implements WeatherService {

	@Override
	public String forecast() {
		return "Today is a rainy day!!";
	}
}
