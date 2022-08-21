package com.student.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepo;

	@Override
	public Student saveStudent(Student student) {

		return studentRepo.save(student);
	}

	@Override
	public Student studentById(Long studentId) {

		Optional<Student> optional = studentRepo.findById(studentId);
		if (!optional.isPresent()) {
			throw new RuntimeException("Student record not found");
		}

		return optional.get();
	}

	@Override
	public Student updateStudent(Long studentId, Student student) {
		Student student2 = studentById(studentId);
		student2.setFirstName(student.getFirstName());
		student2.setLastName(student.getLastName());
		student2.setAge(student.getAge());
		student2.setEmail(student.getEmail());

		return studentRepo.save(student2);
	}

	@Override
	public void deleteStudent(Long studentId) {
		studentRepo.deleteById(studentId);
	}
}
