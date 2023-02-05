package com.collegeDebate.service;

import java.util.List;

import com.collegeDebate.entity.Student;

public interface StudentService {
	Student findById(Long id);

	Student saveStudent(Student student);

	Student updateStudent(Student student, Long id) ;

	void deleteStudent(Long id) throws Exception;

	List<Student> findAllStudents();
}