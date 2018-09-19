package com.practice.sprngbootnglrcss.converter;

import com.practice.sprngbootnglrcss.dto.SkillDto;
import com.practice.sprngbootnglrcss.entity.Skill;

public class SkillConverter {
	public static Skill dtoToEntity(SkillDto skillDto) {
		Skill skill = new Skill(skillDto.getSkillName());
		skill.setSkillId(skillDto.getSkillId());
		return skill;
	}
	public static SkillDto entityToDto(Skill skill) {
		return new SkillDto(skill.getSkillId(), skill.getSkillName());
	}
}
