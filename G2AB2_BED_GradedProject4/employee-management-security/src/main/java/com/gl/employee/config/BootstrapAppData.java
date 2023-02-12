package com.gl.employee.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.gl.employee.dao.EmployeeRepository;
import com.gl.employee.dao.RoleRepository;
import com.gl.employee.dao.UserRepository;
import com.gl.employee.model.Employee;
import com.gl.employee.model.Role;
import com.gl.employee.model.User;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class BootstrapAppData {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final EmployeeRepository employeeRepository;
	private final PasswordEncoder passwordEncoder;


	@EventListener(ApplicationReadyEvent.class)
	public void initializeData(ApplicationReadyEvent readyEvent) {

		Employee ravi = new Employee("Ravi", "Kumar", "ravi@abc.com");
		Employee harish = new Employee("Harish", "Prasad", "harish@abc.com");
		Employee ramesh = new Employee("Ramesh", "Patil", "ramesh@abc.com");
		Employee krishna = new Employee("Krishna", "Patel", "krisna@abc.com");

		this.employeeRepository.save(ravi);
		this.employeeRepository.save(harish);
		this.employeeRepository.save(ramesh);
		this.employeeRepository.save(krishna);
	}

	@EventListener(ApplicationReadyEvent.class)
	@Transactional
	public void initializeUsersData(ApplicationReadyEvent readyEvent) {

			User kiran = new User("kiran", passwordEncoder.encode("welcome"));
			User vinay = new User("vinay", passwordEncoder.encode("welcome"));

			Role userRole = new Role("ROLE_USER");
			Role adminRole = new Role("ROLE_ADMIN");

			this.roleRepository.save(userRole);
			this.roleRepository.save(adminRole);

			kiran.addRole(userRole);
			vinay.addRole(adminRole);

			this.userRepository.save(kiran);
			this.userRepository.save(vinay);

	}

}

