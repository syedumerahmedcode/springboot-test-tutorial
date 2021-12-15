package com.umer.springboottesttutorial.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.umer.springboottesttutorial.repository.StudentRepository;

public class StudentServiceTest {

	@Mock
	private StudentRepository studentRepository;

	private AutoCloseable autoCloseable;
	private StudentService underTest;

	@BeforeEach
	void setUp() {
		/**
		 * If we have more than one mock, it will initialize all the mocks in this test
		 * class.
		 */
		autoCloseable = MockitoAnnotations.openMocks(this);
		underTest = new StudentService(studentRepository);
	}

	@AfterEach
	void tearDown() throws Exception {
		autoCloseable.close();
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
