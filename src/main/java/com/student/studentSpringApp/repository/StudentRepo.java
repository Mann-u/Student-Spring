package com.student.studentSpringApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.studentSpringApp.dto.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

	
	
}
