package com.konasl.practice.accessingdatamysql.repository;

import com.konasl.practice.accessingdatamysql.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
