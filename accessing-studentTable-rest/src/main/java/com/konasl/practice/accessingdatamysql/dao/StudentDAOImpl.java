package com.konasl.practice.accessingdatamysql.dao;

import com.konasl.practice.accessingdatamysql.domain.Student;
import com.konasl.practice.accessingdatamysql.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> findAllStudent() {
		return studentRepository.findAll();
	}

	@Override
	public Student findOneStudent(Integer studentId) {
		return studentRepository.findById(studentId).orElse(new Student());
	}

	@Override
	public void deleteStudent(Student student) {
		studentRepository.delete(student);
	}
}
