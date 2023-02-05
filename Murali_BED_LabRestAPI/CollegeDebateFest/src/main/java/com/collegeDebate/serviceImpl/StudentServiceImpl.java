package com.collegeDebate.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegeDebate.entity.Student;
import com.collegeDebate.repo.StudentRepository;
import com.collegeDebate.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
    	
        return studentRepository.save(student);
    	
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteStudent(Long id) throws Exception {
			studentRepository.deleteById(id);
    }

	@Override
	public Student findById(Long id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student, Long id) {
		Student foundStudent = studentRepository.findById(id).get();
			foundStudent.setFirstName(student.getFirstName());
			foundStudent.setLastName(student.getLastName());
			foundStudent.setCountry(student.getCountry());
			foundStudent.setCourse(student.getCourse());
			foundStudent.setRole(student.getRole());
			return studentRepository.save(foundStudent);
	}
}
