package com.konasl.practice.accessingdatamysql.dao;

import com.konasl.practice.accessingdatamysql.domain.Student;

import java.util.List;

public interface StudentDAO {

	public Student saveStudent(Student student);

	public List<Student> findAllStudent();

	public Student findOneStudent(Integer studentId);

	public void deleteStudent(Student student);
}
