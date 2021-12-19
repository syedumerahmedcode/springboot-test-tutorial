package com.umer.springboottesttutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.umer.springboottesttutorial.repository.StudentRepository;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerIT {
	
	@Autowired
	private StudentRepository studentRepository;
	
    private static MockWebServer mockWebServer;

}
