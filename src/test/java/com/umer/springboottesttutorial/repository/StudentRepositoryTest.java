package com.umer.springboottesttutorial.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.umer.springboottesttutorial.entity.Gender;
import com.umer.springboottesttutorial.entity.Student;

public class StudentRepositoryTest {
	
	@Autowired
	private StudentRepository underTest;
	
	@Test
	void itShouldCheckIfStudentExistsByEmail() {
		// given
		String email="some.email@gmail.com";
		Student student=new Student("Alice", email, Gender.FEMALE);
		
		// when
		boolean expected= underTest.selectExistsEmail(email);		
		
		
		// then
		assertThat(expected).isTrue();
		
	}

}
