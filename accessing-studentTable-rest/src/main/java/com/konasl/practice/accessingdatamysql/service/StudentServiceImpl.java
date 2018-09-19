package com.konasl.practice.accessingdatamysql.service;

import com.konasl.practice.accessingdatamysql.dao.StudentDAO;
import com.konasl.practice.accessingdatamysql.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDAO studentDAOInterface;

	@Override
	public Student saveOneStudent(Student student) {
		return studentDAOInterface.saveStudent(student);
	}

	@Override
	public @Nullable Student updateOneStudent(Integer studentTobeUpdatedId, Student studentInfo) {

		Student studentTobeUpdated = studentDAOInterface.findOneStudent(studentTobeUpdatedId);

		if (studentTobeUpdated != null) {
			studentTobeUpdated.setClassOfStudent(studentInfo.getClassOfStudent());
			studentTobeUpdated.setSection(studentInfo.getSection());
			studentTobeUpdated.setFirstName(studentInfo.getFirstName());
			studentTobeUpdated.setLastName(studentInfo.getLastName());
			studentTobeUpdated.setRollNo(studentInfo.getRollNo());
			studentDAOInterface.saveStudent(studentTobeUpdated);
		}

		return studentTobeUpdated;
	}

	@Override
	public List<Student> findAllStudents() {
		return studentDAOInterface.findAllStudent();
	}

	@Override
	public @Nullable Student findOneStudent(Integer studentId) {
		return studentDAOInterface.findOneStudent(studentId);
	}

	@Override
	public void deleteOneStudent(Student student) {
		studentDAOInterface.deleteStudent(student);
	}

	@Override
	public void assignStudentInClass(Student student, Integer className, String section) {
		student.setClassOfStudent(className);
		student.setSection(section);
	}

	@Override
	public void removeStudentFromClass(Student student) {
		student.setClassOfStudent(null);
		student.setSection(null);
	}
}
