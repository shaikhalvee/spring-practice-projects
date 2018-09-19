package com.practice.springbootcrudangljs.dao;

import com.practice.springbootcrudangljs.model.Employee;
import com.practice.springbootcrudangljs.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private final EmployeeRepository repository;

	@Autowired
	public EmployeeDAOImpl(EmployeeRepository repository) {
		this.repository = repository;
	}

	@Override
	public Employee getOneEmployee(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Employee> findAllEmployees() {
		return repository.findAll();
	}

	@Override
	public void createEmployee(Employee employee) {
		repository.save(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		repository.save(employee);
	}

	@Override
	public void deleteOneEmployee(Long id) {
		repository.deleteById(id);
	}

	@Override
	public void deleteAllEmployees() {
		repository.deleteAll();
	}
}
