package com.practice.springbootcrudangljs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long employeeId;
	@NotNull
	private String employeeNo;
	@NotNull
	private String employeeName;

	private String position;

	public Employee(EmployeeForm employeeForm) {
		this.employeeId = employeeForm.getEmployeeId();
		this.employeeName = employeeForm.getEmployeeName();
		this.employeeNo = employeeForm.getEmployeeNo();
		this.position = employeeForm.getPosition();
	}

}
