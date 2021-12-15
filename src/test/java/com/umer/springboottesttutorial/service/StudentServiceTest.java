package com.umer.springboottesttutorial.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.umer.springboottesttutorial.repository.StudentRepository;

public class StudentServiceTest {

	private StudentRepository studentRepository; 
	private StudentService underTest;
	
	@BeforeEach
	void setUp() {
		underTest=new StudentService(studentRepository);
	}
	
	@Test
	void getAllStudents() {
		
	}
	
	@Test
	@Disabled
	void addStudent() {
		
	}
	
	@Test
	@Disabled
	void deleteStudent() {
		
	}
}
