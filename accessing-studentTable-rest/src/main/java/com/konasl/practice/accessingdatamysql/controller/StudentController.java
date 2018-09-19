package com.konasl.practice.accessingdatamysql.controller;

import com.konasl.practice.accessingdatamysql.domain.Student;
import com.konasl.practice.accessingdatamysql.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping("/create")
	public Student createStudent(@Valid @RequestBody Student student) {
		return studentService.saveOneStudent(student);
	}

	@GetMapping("/all")
	@ResponseBody
	public List<Student> getAllStudents() {
		return studentService.findAllStudents();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") Integer studentId) {
		Student returnStudent = studentService.findOneStudent(studentId);

		if (returnStudent == null)
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok().body(returnStudent);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Integer studentId, @Valid @RequestBody Student studentDetails) {
		Student updatedStudent = studentService.updateOneStudent(studentId, studentDetails);
		if (updatedStudent == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(updatedStudent);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Student> removeStudent(@PathVariable(value = "id") Integer studentId) {
		Student studentTobeDeleted = studentService.findOneStudent(studentId);
		if (studentTobeDeleted == null)
			return ResponseEntity.notFound().build();
		studentService.deleteOneStudent(studentTobeDeleted);
		return ResponseEntity.ok().build();
	}

}
