package com.practice.springbootrestapidata.repository;

import com.practice.springbootrestapidata.domain.WebsiteUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "users", path = "user")
public interface UserRepository extends JpaRepository<WebsiteUser, Long> {
}
