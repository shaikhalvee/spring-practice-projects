package com.practice.sprngbootnglrcss.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
public class Skill {

	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer skillId;
	@Column
	private String skillName;

	@ManyToOne
	private User user;

	public Skill(String skillName) {
		this.skillName = skillName;
	}
}
