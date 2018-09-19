package com.practice.sprngbootnglrcss.converter;

import com.practice.sprngbootnglrcss.dto.UserDto;
import com.practice.sprngbootnglrcss.entity.User;

import java.util.stream.Collectors;

public class UserConverter {
	public static User dtoToEntity(UserDto userDto) {
		User user = new User(userDto.getUserName(), null);
		user.setUserId(userDto.getUserId());
		user.setSkills(userDto.getSkillDtoList().stream().map(SkillConverter::dtoToEntity).collect(Collectors.toList()));
		return user;
	}
	public static UserDto entityToDto(User user) {
		UserDto userDto = new UserDto(user.getUserId(), user.getUserName(), null);
		userDto.setSkillDtoList(user.getSkills().stream().map(SkillConverter::entityToDto).collect(Collectors.toList()));
		return userDto;
	}
}
