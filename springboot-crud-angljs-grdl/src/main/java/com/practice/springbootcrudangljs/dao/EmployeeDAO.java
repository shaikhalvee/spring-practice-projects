package com.practice.springbootcrudangljs.dao;

import com.practice.springbootcrudangljs.model.Employee;
import org.springframework.lang.Nullable;

import java.util.List;

public interface EmployeeDAO {

	@Nullable Employee getOneEmployee(Long id);

	List<Employee> findAllEmployees();

	void createEmployee(Employee employee);

	void updateEmployee(Employee employee);

	void deleteOneEmployee(Long id);

	void deleteAllEmployees();

}
