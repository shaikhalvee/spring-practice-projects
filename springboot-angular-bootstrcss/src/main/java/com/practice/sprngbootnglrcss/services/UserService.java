package com.practice.sprngbootnglrcss.services;

import com.practice.sprngbootnglrcss.dto.UserDto;

import java.util.List;

public interface UserService {
	UserDto getUserById(Integer userId);
	void saveUser(UserDto userDto);
	List<UserDto> getAllUsers();
}
