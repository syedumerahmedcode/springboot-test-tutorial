package com.umer.springboottesttutorial.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.umer.springboottesttutorial.entity.Student;
import com.umer.springboottesttutorial.repository.StudentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService {

	private final StudentRepository studentRepository;
	
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
}
