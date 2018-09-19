package com.practice.springbootcrudangljs.controller;

import com.practice.springbootcrudangljs.model.Employee;
import com.practice.springbootcrudangljs.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainRestController {

	private final EmployeeService employeeService;

	@Autowired
	public MainRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// URL:
	// http://localhost:8080/SomeContextPath/employees
	// http://localhost:8080/SomeContextPath/employees.xml
	// http://localhost:8080/SomeContextPath/employees.json
	@RequestMapping(value = "/employees",
					method = RequestMethod.GET,
					produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<Employee> getEmployees() {
		return employeeService.findAllEmployees();
	}
}
