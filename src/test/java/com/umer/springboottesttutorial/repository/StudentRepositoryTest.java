package com.umer.springboottesttutorial.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.umer.springboottesttutorial.entity.Gender;
import com.umer.springboottesttutorial.entity.Student;

@DataJpaTest
public class StudentRepositoryTest {

	@Autowired
	private StudentRepository underTest;

	@BeforeEach
	void setUp() {
		// Not used in this test class
	}

	@AfterEach
	void tearDown() {
		/**
		 * I wonder if this is really necessary as the database is an in-memory database
		 * which is initialized before every test run and dropped after every test run
		 * due to the following property in application.properties.
		 * 
		 * spring.jpa.hibernate.ddl-auto=create-drop
		 */
		underTest.deleteAll();
	}

	@Test
	void whenStudentEmailExistsInDatabase_ThenExistEmailReturnsTrue() {
		// given
		String email = "some.email@gmail.com";
		Student student = new Student("Alice", email, Gender.FEMALE);
		underTest.save(student);

		// when
		boolean expected = underTest.selectExistsEmail(email);

		// then
		assertThat(expected).isTrue();
	}
	
	@Test
	void whenStudentIsSavedInDatabaseAndFindStudentByEmail_ThenStudentIsReturned() {
		// given
		String email = "some.email@gmail.com";
		Student student = new Student("Alice", email, Gender.FEMALE);
		underTest.save(student);

		// when
		boolean StudentExists = underTest.selectExistsEmail(email);
		Student studentFound=underTest.findByEmail(email);

		// then
		assertThat(StudentExists).isTrue();
		assertThat(studentFound).isEqualTo(student);
	}

	@Test
	void whenStudentEmailDoesNotExistsInDatabase_ThenExistEmailReturnsFalse() {
		// given
		String email = "some.email@gmail.com";

		// when
		boolean expected = underTest.selectExistsEmail(email);

		// then
		assertThat(expected).isFalse();
	}

	@ParameterizedTest
	@NullAndEmptySource
	void whenStudentEmailIsNotPassed_ThenExistEmailReturnsFalse(String email) {

		// when
		boolean expected = underTest.selectExistsEmail(email);

		// then
		assertThat(expected).isFalse();
	}

}
