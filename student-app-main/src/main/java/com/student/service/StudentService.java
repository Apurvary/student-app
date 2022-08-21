package com.student.service;

import com.student.entity.Student;

public interface StudentService {

	Student saveStudent(Student student);

	Student studentById(Long studentId);

	Student updateStudent(Long studentId, Student student);

	void deleteStudent(Long studentId);
}
