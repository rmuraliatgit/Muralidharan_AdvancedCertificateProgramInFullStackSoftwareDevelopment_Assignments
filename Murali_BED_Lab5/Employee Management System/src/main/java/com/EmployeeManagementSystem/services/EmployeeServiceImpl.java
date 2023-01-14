package com.EmployeeManagementSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeManagementSystem.dao.*;
import com.EmployeeManagementSystem.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
//		Employee newEmployee = new Employee();
//		newEmployee.setEmail(employee.getEmail());
//		newEmployee.setFirstName(employee.getFirstName());
//		newEmployee.setLastName(employee.getLastName());
//		System.out.println(employee.getEmail()+employee.getFirstName()+employee.getLastName());
		Employee savedEmp = employeeRepository.save(employee);
		return savedEmp;
	}

	@Override
	public void removeEmployee(Long id) {
		employeeRepository.deleteById(id);

	}

	@Override
	public Employee updateEmployee(Long id, Employee employee) {
		Optional<Employee> updatedEmployee = employeeRepository.findById(id);
		updatedEmployee.get().setEmail(employee.getEmail());
		updatedEmployee.get().setFirstName(employee.getFirstName());
		updatedEmployee.get().setLastName(employee.getLastName());
		employeeRepository.save(updatedEmployee.get());
		return updatedEmployee.get();
	}

	@Override
	public List<Employee> listOfEmployee() {
		List<Employee> allEmployees = employeeRepository.findAll();
		return allEmployees;
	}


}
