package com.niit;


import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.niit.controller.StudentController;
import com.niit.entity.Student;
import com.niit.exception.StudentServiceException;
import com.niit.service.StudentService;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private StudentService studentService;

	@InjectMocks
	private StudentController studentController;

	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();

	}

	@Test
	public void saveStudentValidTest() throws JsonProcessingException, Exception {
		Student student = new Student("john@gmail.com", "John", "Dagger", "CS");
		Mockito.when(studentService.saveStudent(any())).thenReturn(student);
		mockMvc.perform(post("/api/student").contentType(MediaType.APPLICATION_JSON).content(jsonToString(student)))
				.andExpect(status().isCreated());
	}

	@Test
	public void saveStudentInValidTest() throws JsonProcessingException, Exception {

		Student student = new Student("john@gmail.com", "John", "Dagger", "CS");

		Mockito.when(studentService.saveStudent(any())).thenThrow(new StudentServiceException("invalid"));
		Assertions.assertThatThrownBy(() -> mockMvc
				.perform(post("/api/student").contentType(MediaType.APPLICATION_JSON).content(jsonToString(student))))
				.hasCause(new StudentServiceException("invalid"));

	}

	private static String jsonToString(final Object ob) throws JsonProcessingException {
		String result;

		try {
			ObjectMapper mapper = new ObjectMapper();
			String jsonContent = mapper.writeValueAsString(ob);
			result = jsonContent;
		} catch (JsonProcessingException e) {
			result = "JSON processing error";
		}

		return result;
	}
}
