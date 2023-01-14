package com.EmployeeManagementSystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.EmployeeManagementSystem.dao.EmployeeRepository;
import com.EmployeeManagementSystem.entity.Employee;
import com.EmployeeManagementSystem.services.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	EmployeeService employeeService;

    @GetMapping("")
    public String getAllEmployees(Model model) {
        List<Employee> employees = employeeService.listOfEmployee();
        System.out.println(employees.toString());
        model.addAttribute("employees", employees);
        return "list";
    }

    @GetMapping("/new")
    public String createEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "create-employee";
    }

    @PostMapping("")
    public String createEmployee(Employee employee) {
    	employeeService.addEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String updateEmployeeForm(@PathVariable Long id, Model model) {
        Optional<Employee> employee = employeeRepository.findById(id);
        model.addAttribute("employee", employee.get());
        return "edit";
    }

    @PostMapping("/{id}")
    public String updateEmployee(@PathVariable Long id, Employee employeeDetails) {
    	employeeService.updateEmployee(id, employeeDetails);
        return "redirect:/employees";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
    	employeeService.removeEmployee(id);
        return "redirect:/employees";
    }
}
