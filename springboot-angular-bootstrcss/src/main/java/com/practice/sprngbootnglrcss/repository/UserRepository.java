package com.practice.sprngbootnglrcss.repository;

import com.practice.sprngbootnglrcss.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
