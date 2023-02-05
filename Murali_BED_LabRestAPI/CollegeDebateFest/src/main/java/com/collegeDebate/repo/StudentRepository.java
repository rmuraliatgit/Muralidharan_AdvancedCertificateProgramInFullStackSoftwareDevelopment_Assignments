package com.collegeDebate.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collegeDebate.entity.Student;



@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
}
