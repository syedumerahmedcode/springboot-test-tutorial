package com.umer.springboottesttutorial.controller;

import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerIT {

//	@Autowired
//	private WebTestClient webClient;
//
//	@Autowired
//	private StudentRepository studentRepository;
//
//	private static MockWebServer mockWebServer;

	@BeforeAll
	static void setupMockWebServer() throws IOException {
//		mockWebServer = new MockWebServer();
//		mockWebServer.start();
	}

	@AfterEach
	void deleteEntities() {
//		studentRepository.deleteAll();
	}

	@Test
	void createOrder() {
		// given
//		Student student = new Student("Alice", "some.email@gmail.com", Gender.FEMALE);
//		List<Student> students = new ArrayList<>();
//		students.add(student);
//		Long studentId = studentRepository.save(student).getId();

//		webClient.post()
//			.uri("/api/v1/students", studentId)
//	        .contentType(MediaType.APPLICATION_JSON)
//	        .exchange()
//	        .expectStatus()
//	        .isCreated();

		// TODO: Need help in implementing this type of test. If someone can help,
		// please feel free to create a Pull Request.
	}

}
