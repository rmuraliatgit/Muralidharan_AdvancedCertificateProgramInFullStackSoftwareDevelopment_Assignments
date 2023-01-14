package com.EmployeeManagementSystem.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EmployeeManagementSystem.entity.*;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	
	Optional<Employee> findById(Long id);
	
	Employee findByEmail(String email);

}
