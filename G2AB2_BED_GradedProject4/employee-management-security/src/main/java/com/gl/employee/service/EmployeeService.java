package com.gl.employee.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import com.gl.employee.model.Employee;
import com.gl.employee.model.Role;
import com.gl.employee.model.User;

public interface EmployeeService {

	void saveEmployee(Employee employee);

	List<Employee> findAll();

	Employee findById(long id);

	Employee updateEmployee(int id, Employee employee);

	void deleteById(long id);

	List<Employee> findByName(String name);

	List<Employee> sortEmployees(Direction direction);

	User saveUser(User user);

	Role saveRole(Role role);


//	<dependency>
//		<groupId>org.springframework.security</groupId>
//		<artifactId>spring-security-test</artifactId>
//		<scope>test</scope>
//	</dependency>
//	<dependency>
//	<groupId>org.springframework.boot</groupId>
//	<artifactId>spring-boot-starter-security</artifactId>
//</dependency>
}
