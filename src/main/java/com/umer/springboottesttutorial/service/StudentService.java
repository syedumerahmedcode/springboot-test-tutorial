package com.umer.springboottesttutorial.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.umer.springboottesttutorial.entity.Student;
import com.umer.springboottesttutorial.exception.BadRequestException;
import com.umer.springboottesttutorial.repository.StudentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService {

	private final StudentRepository studentRepository;
	
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	public void addStudent(Student student) {
		final String email = student.getEmail();
		Boolean emailExists= studentRepository.selectExistsEmail(email);
		if(emailExists) {
			throw new BadRequestException("Email " + email + " taken");
		}
		studentRepository.save(student);
	}
}
