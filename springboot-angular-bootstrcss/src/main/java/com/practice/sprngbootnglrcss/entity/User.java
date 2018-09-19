package com.practice.sprngbootnglrcss.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class User implements Serializable {

	private static final long serialVersionUID = 0x62A6DA99AABDA8A8L;

	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer userId;

	@Column
	private String userName;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Skill> skills= new LinkedList<>();

	public User(String userName, List<Skill> skills) {
		this.userName = userName;
		this.skills = skills;
	}

}
