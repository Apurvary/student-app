package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("students")
	public Student saveStudent(@RequestBody Student student) {

		return studentService.saveStudent(student);
	}

	@GetMapping("students/{studentId}")
	public Student studentById(@PathVariable Long studentId) {

		return studentService.studentById(studentId);
	}

	@PutMapping("students/{studentId}")
	public Student updateStudent(@PathVariable Long studentId, @RequestBody Student student) {

		return studentService.updateStudent(studentId, student);
	}

	@DeleteMapping("students/{studentId}")
	public void deleteStudent(@PathVariable Long studentId) {

		studentService.deleteStudent(studentId);
	}
}
