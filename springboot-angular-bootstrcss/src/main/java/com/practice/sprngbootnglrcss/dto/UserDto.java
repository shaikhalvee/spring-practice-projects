package com.practice.sprngbootnglrcss.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	Integer userId;
	String userName;
	List<SkillDto> skillDtoList= new ArrayList<>();
}
