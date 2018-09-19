package com.practice.jpa.springbootjpahibgrdl.repository;

import com.practice.jpa.springbootjpahibgrdl.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IUsersRepository extends JpaRepository<Users, Integer> {

	Optional<List<Users>> findByName(String name);
}
