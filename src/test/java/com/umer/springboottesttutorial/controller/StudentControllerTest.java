package com.umer.springboottesttutorial.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

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
		Student student=new Student("Alice", "some.email@gmail.com", Gender.FEMALE);
		List<Student> students=new ArrayList<>();
		students.add(student);
		when(studentService.getAllStudents()).thenReturn(students);
		
		mockMvc.perform(get("/api/v1/students"))
		 	.andExpect(jsonPath("$.name").isNotEmpty())
		 	.andExpect(jsonPath("$.email").value("some.email@gmail.com"))
		 	.andExpect(jsonPath("$.gender").value(Gender.FEMALE));
	}

}
