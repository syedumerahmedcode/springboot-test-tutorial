package com.umer.springboottesttutorial.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.umer.springboottesttutorial.entity.Gender;
import com.umer.springboottesttutorial.entity.Student;
import com.umer.springboottesttutorial.exception.BadRequestException;
import com.umer.springboottesttutorial.exception.StudentNotFoundException;
import com.umer.springboottesttutorial.repository.StudentRepository;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

	@Mock
	private StudentRepository studentRepository;
//	private AutoCloseable autoCloseable;
	private StudentService underTest;

	@BeforeEach
	void setUp() {
		/**
		 * If we have more than one mock, it will initialize all the mocks in this test
		 * class.
		 */
//		autoCloseable = MockitoAnnotations.openMocks(this);
		underTest = new StudentService(studentRepository);
	}

	@AfterEach
	void tearDown() throws Exception {
//		autoCloseable.close();
	}

	@Test
	void whenGetAllStudentsIsCalled_ThenVerifyThatFindAllForRepositoryIsUsed() {
		// when
		underTest.getAllStudents();
		// then
		/**
		 * check that findAll method on the mock bean is called
		 */
		verify(studentRepository).findAll();

	}

	@Test
	void whenAddStudent_ThenPass() {
		// given
		String email = "some.email@gmail.com";
		Student student = new Student("Alice", email, Gender.FEMALE);

		// when
		underTest.addStudent(student);

		// then
		// TODO: Add 'why' comments for better explanation.
		ArgumentCaptor<Student> studentArgumentCaptor = ArgumentCaptor.forClass(Student.class);
		verify(studentRepository).save(studentArgumentCaptor.capture());

		final Student capturedStudent = studentArgumentCaptor.getValue();
		assertThat(capturedStudent).isEqualTo(student);
	}

	@Test
	void whenStudentEmailIsAlreadyTaken_ThenThrowException() {
		// given
		String email = "some.email@gmail.com";
		Student student = new Student("Alice", email, Gender.FEMALE);
		given(studentRepository.selectExistsEmail(student.getEmail())).willReturn(true);

		// when
		// then
		assertThatThrownBy(() -> underTest.addStudent(student)).isInstanceOf(BadRequestException.class)
				.hasMessageContaining("Email " + email + " already taken.");
		verify(studentRepository, never()).save(ArgumentMatchers.any());
	}

	@Test
	void whenDeletingAnExistingStudent_ThenPass() {
		// given
		long studentId = 10;
		given(studentRepository.existsById(studentId)).willReturn(true);

		// when
		underTest.deleteStudent(studentId);

		// then
		verify(studentRepository).deleteById(studentId);
	}

	@Test
	void whenDeletingAStudentWhichIsNotPresent_ThenThrowAnError() {
		// given
		long studentId = 10;
		given(studentRepository.existsById(studentId)).willReturn(false);

		// when
		// then
		assertThatThrownBy(() -> underTest.deleteStudent(studentId)).isInstanceOf(StudentNotFoundException.class)
				.hasMessageContaining("Student with id " + studentId + " does not exists.");
		verify(studentRepository, never()).deleteById(ArgumentMatchers.any());
	}

}
