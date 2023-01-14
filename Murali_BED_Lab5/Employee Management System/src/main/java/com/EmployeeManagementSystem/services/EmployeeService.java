package com.EmployeeManagementSystem.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.EmployeeManagementSystem.entity.Employee;

@Service
public interface EmployeeService {
	Employee addEmployee(Employee employee);
		
	Employee updateEmployee(Long id, Employee employee);
	
	List<Employee> listOfEmployee();
	
	public void removeEmployee(Long id);
}
