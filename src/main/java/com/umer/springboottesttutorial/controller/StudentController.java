package com.umer.springboottesttutorial.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.umer.springboottesttutorial.entity.Student;
import com.umer.springboottesttutorial.service.StudentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "api/v1/students")
@AllArgsConstructor
public class StudentController {

	private final StudentService studentService;

	@GetMapping
//    public List<Student> getAllStudents() {
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> student= studentService.getAllStudents();
		return ResponseEntity.ok().body(student);
	}

	@PostMapping
	public void addStudent(@Valid @RequestBody Student student) {
		studentService.addStudent(student);
	}

	@DeleteMapping(path = "{studentId}")
	public void deleteStudent(@PathVariable("studentId") Long studentId) {
		studentService.deleteStudent(studentId);
	}

}
