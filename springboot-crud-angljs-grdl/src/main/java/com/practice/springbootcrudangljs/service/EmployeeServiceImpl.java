package com.practice.springbootcrudangljs.service;

import com.practice.springbootcrudangljs.dao.EmployeeDAO;
import com.practice.springbootcrudangljs.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeDAO dao;

	@Autowired
	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		this.dao = employeeDAO;
	}

	@Override
	public void createOneEmployee(Employee employeeInfo) {
		dao.createEmployee(employeeInfo);
	}

	@Override
	public void saveOneEmployee(Employee employee) {
		dao.createEmployee(employee);
	}

	@Override
	public List<Employee> findAllEmployees() {
		return dao.findAllEmployees();
	}

	@Override
	public Employee findOneEmployee(Long employeeId) {
		return dao.getOneEmployee(employeeId);
	}

	@Override
	public void deleteOneEmployee(Employee employee) {
		dao.deleteOneEmployee(employee.getEmployeeId());
	}

	@Override
	public void deleteAllEmployees() {
		dao.deleteAllEmployees();
	}
}
