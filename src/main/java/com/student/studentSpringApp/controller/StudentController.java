package com.student.studentSpringApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.studentSpringApp.dao.StudentDao;
import com.student.studentSpringApp.dto.Student;

//used for making restful web services and used at the class level
//and allows to hadle the request made by the client.

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	StudentDao stuDao;
	
	@PostMapping
	public Student saveData(@RequestBody Student student) {
		return stuDao.saveStudent(student);
	}
	
	@GetMapping("/{id}")
	public Student getStudById(@PathVariable int id) {
		Optional<Student> op = stuDao.getStudentById(id);
		if (op.isEmpty()) {
			return null;
		} else {
			return op.get();
		}
	}
	
	@GetMapping
	public List<Student> getAllStudent()
	{
		return stuDao.getAllStudent();
	}
	
	@PutMapping
	public Student updateStudent(@RequestBody Student stu) {
		return stuDao.updateStudent(stu);
	}
	
	@DeleteMapping
	public String deleteStudent(@RequestParam int id) {
		Optional<Student> op = stuDao.getStudentById(id);
		if (op.isPresent()) {
			stuDao.deleteStd(id);
			return "Student data deleted";
		} else {
			return "Student data not found";
		}
	}

}
