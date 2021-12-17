package com.umer.springboottesttutorial.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.umer.springboottesttutorial.entity.Gender;
import com.umer.springboottesttutorial.entity.Student;
import com.umer.springboottesttutorial.service.StudentService;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {

	@MockBean
	private StudentService studentService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getAllStudents() throws Exception {
		// given
		Student student = new Student("Alice", "some.email@gmail.com", Gender.FEMALE);
		List<Student> students = new ArrayList<>();
		students.add(student);
		when(studentService.getAllStudents()).thenReturn(students);

		// when
		final MockHttpServletRequestBuilder requestBuilderForGetAllStudents = get("/api/v1/students");
		final ResultActions performHTTPCallForGetAllStudents = mockMvc.perform(requestBuilderForGetAllStudents);

		// then
		final MockHttpServletResponse mvcResponse = performHTTPCallForGetAllStudents
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn()
				.getResponse();
		// TODO: Either, pass the actual json in a file, or
		// TODO: Use $jsonPath to check for jsonArray.
		/**
		 * Please note that we are not using a response DTO in this project. With a
		 * response DTO, this assertion would be carried out slightly differently.
		 */
		String actualStudentsJson="[{\"id\":null,\"name\":\"Alice\",\"email\":\"some.email@gmail.com\",\"gender\":\"FEMALE\"}]";
		assertThat(mvcResponse.getContentAsString()).isEqualTo(
				actualStudentsJson);

	}

}
