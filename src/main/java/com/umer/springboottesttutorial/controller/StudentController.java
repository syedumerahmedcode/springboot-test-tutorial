package com.umer.springboottesttutorial.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.umer.springboottesttutorial.service.StudentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "api/v1/students")
@AllArgsConstructor
public class StudentController {
	
	private final StudentService studentService;

}
