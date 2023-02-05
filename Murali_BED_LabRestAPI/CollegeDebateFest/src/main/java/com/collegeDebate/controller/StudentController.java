package com.collegeDebate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.annotation.Secured;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.collegeDebate.entity.Student;
import com.collegeDebate.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

  @Autowired
  private StudentService studentService;

  //@Secured({"ROLE_ADMIN", "ROLE_USER"})
  @PostMapping
  public ResponseEntity<Student> addStudent(@RequestBody Student student) {
    Student newStudent = studentService.saveStudent(student);
    return ResponseEntity.ok(newStudent);
  }

  // @PreAuthorize("hasRole('ROLE_ADMIN')")
  @PutMapping("/{id}")
  public ResponseEntity<String> updateStudent(@RequestBody Student student, @PathVariable Long id) {
    
    Student foundStudent = studentService.findById(id);
    System.out.println(foundStudent.getRole().getRolename());
	if(foundStudent.getRole().getRolename().equals("ROLE_ADMIN"))
	{
		studentService.updateStudent(student, id);
		return new ResponseEntity<>("Student updated successfully", HttpStatus.OK);
	}
		else return new ResponseEntity<>("You are not authorized to update", HttpStatus.BAD_REQUEST);
	
  }


  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteStudent(@PathVariable Long id) throws Exception {
	  Student foundStudent = studentService.findById(id);
  
	  if(foundStudent.getRole().getRolename().equals("ROLE_ADMIN"))
		{
		    studentService.deleteStudent(id);
		    return ResponseEntity.ok("Deleted Successfully");
		}
	  else return new ResponseEntity<>("You are not authorized to delete", HttpStatus.BAD_REQUEST);
  }

  //@PreAuthorize("hasRole('ROLE_ADMIN', 'ROLE_USER')")
  @GetMapping
  public ResponseEntity<List<Student>>  getAllStudents() {
    List<Student> listOfStudents= studentService.findAllStudents();
    return ResponseEntity.ok(listOfStudents);
  }

}

