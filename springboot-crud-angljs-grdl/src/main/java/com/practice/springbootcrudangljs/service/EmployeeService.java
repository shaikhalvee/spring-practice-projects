package com.practice.springbootcrudangljs.service;

import com.practice.springbootcrudangljs.model.Employee;
import org.springframework.lang.Nullable;

import java.util.List;

public interface EmployeeService {

	void createOneEmployee(Employee employeeInfo);

	void saveOneEmployee(Employee employee);

	List<Employee> findAllEmployees();

	@Nullable Employee findOneEmployee(Long employeeId);

	void deleteOneEmployee(Employee employee);

	void deleteAllEmployees();
}
