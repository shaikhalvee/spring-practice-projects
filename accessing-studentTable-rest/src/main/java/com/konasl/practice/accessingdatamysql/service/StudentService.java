package com.konasl.practice.accessingdatamysql.service;

import com.konasl.practice.accessingdatamysql.domain.Student;
import org.springframework.lang.Nullable;

import java.util.List;

public interface StudentService {
	public Student saveOneStudent(Student student);

	public List<Student> findAllStudents();

	public @Nullable Student findOneStudent(Integer studentId);

	public @Nullable Student updateOneStudent(Integer studentTobeUpdatedId, Student studentInfo);

	public void deleteOneStudent(Student student);

	public void assignStudentInClass(Student student, Integer className, String section);

	public void removeStudentFromClass(Student student);
}
