package com.student.studentSpringApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.student.studentSpringApp.dto.Student;
import com.student.studentSpringApp.repository.StudentRepo;

//-> used to indicate that the class provides the mechanism to perfom
// all CRUD Operation

@Repository
public class StudentDao {
	
	@Autowired
	StudentRepo studentRepo;
	
	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}
	
	public Optional<Student> getStudentById(int id) {
		return studentRepo.findById(id);
	}
	
	public List<Student> getAllStudent() {
		return studentRepo.findAll();
	}
	
	public Student updateStudent(Student student) {
		return studentRepo.save(student);
	}
	
	public void deleteStd(int id) {
		studentRepo.deleteById(id);
	}
	

}
