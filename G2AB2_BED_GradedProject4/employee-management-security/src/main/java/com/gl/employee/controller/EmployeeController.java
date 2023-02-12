package com.gl.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.employee.model.Employee;
import com.gl.employee.model.Role;
import com.gl.employee.model.User;
import com.gl.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	public void saveEmployees(@RequestBody Employee theEmployee) {
		this.employeeService.saveEmployee(theEmployee);
	}

	@GetMapping("/list")
	public List<Employee> listStudents(Model theModel) {
		List<Employee> theEmployee = employeeService.findAll();
		return theEmployee;
	}

	@GetMapping("/{id}")
	public Employee fetchEmployeesById(@PathVariable("id") int id) {
		return this.employeeService.findById(id);
	}

	@PutMapping("/{id}")
	public Employee updateEmployees(@PathVariable("id") int id, @RequestBody Employee theEmployee) {
		return this.employeeService.updateEmployee(id, theEmployee);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id) {
		this.employeeService.deleteById(id);
		return new ResponseEntity<String>("Deleted employee id - "+id, HttpStatus.OK);
	}

	@GetMapping("/search/{name}")
	public List<Employee> fetchEmployeesByName(@PathVariable("name") String name) {
		return this.employeeService.findByName(name);
	}
	
	@GetMapping("/sort")
	public List<Employee> sortEmployeesByName(@RequestParam("order") String direction) {
		if (!direction.equalsIgnoreCase("ASC") && !direction.equalsIgnoreCase("DESC")) {
			throw new IllegalArgumentException("Invalid value for 'order' parameter. Must be 'ASC' or 'DESC'");
		  }
		
		  Sort.Direction sortDirection = Sort.Direction.fromString(direction.toUpperCase());
		  return this.employeeService.sortEmployees(sortDirection);
	}

	@PostMapping("/user")
	public User saveUser(@RequestBody User user) {
		return employeeService.saveUser(user);
	}

	@PostMapping("/role")
	public Role saveRole(@RequestBody Role role) {
		return employeeService.saveRole(role);
	}

}
