package com.gl.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gl.employee.dao.EmployeeRepository;
import com.gl.employee.dao.RoleRepository;
import com.gl.employee.dao.UserRepository;
import com.gl.employee.model.Employee;
import com.gl.employee.model.Role;
import com.gl.employee.model.User;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder encoder;

	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(long id) {
		return this.employeeRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Id Passed"));
	}

	@Override
	public Employee updateEmployee(int id, Employee employee) {
		Employee theEmployee = this.findById(id);

		theEmployee.setFirstName(employee.getFirstName());
		theEmployee.setLastName(employee.getLastName());
		theEmployee.setEmail(employee.getEmail());

		return this.employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteById(long id) {
		this.employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> findByName(String keyword) {
		if (keyword != null) {
			return employeeRepository.findByName(keyword);
		}
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> sortEmployees(Sort.Direction direction) {
		return this.employeeRepository.findAll(Sort.by(direction, "firstName"));
	}
	
	@Override
	public User saveUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}

}
