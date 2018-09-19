package com.practice.springbootcrudangljs.repository;

import com.practice.springbootcrudangljs.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	Employee getEmployeeByEmployeeName(String name);
}
