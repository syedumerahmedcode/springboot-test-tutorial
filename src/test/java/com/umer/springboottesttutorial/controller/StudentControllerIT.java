package com.umer.springboottesttutorial.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.umer.springboottesttutorial.entity.Gender;
import com.umer.springboottesttutorial.entity.Student;
import com.umer.springboottesttutorial.repository.StudentRepository;

import okhttp3.mockwebserver.MockWebServer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerIT {

	@Autowired
	private WebTestClient webClient;

	@Autowired
	private StudentRepository studentRepository;

	private static MockWebServer mockWebServer;

	@BeforeAll
	static void setupMockWebServer() throws IOException {
		mockWebServer = new MockWebServer();
		mockWebServer.start();
	}

	@AfterEach
	void deleteEntities() {
		studentRepository.deleteAll();
	}

	@Test
	void createOrder() {
		// given
		Student student = new Student("Alice", "some.email@gmail.com", Gender.FEMALE);
		List<Student> students = new ArrayList<>();
		students.add(student);
		Long studentId = studentRepository.save(student).getId();
		
		webClient.post()
			.uri("/api/v1/students", studentId)
	        .contentType(MediaType.APPLICATION_JSON)
	        .exchange()
	        .expectStatus()
	        .isCreated();
	}

}
