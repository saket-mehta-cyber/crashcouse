package com.niit;



import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.niit.entity.Student;
import com.niit.exception.StudentServiceException;
import com.niit.repository.StudentRepository;
import com.niit.service.StudentServiceImpl;

@SpringBootTest
class StudentServiceApplicationTests {

	@Mock
	private StudentRepository studentRepository;

	@InjectMocks
	private StudentServiceImpl serviceImpl;

	@Test
	public void saveStudentValidTest() throws StudentServiceException {
		Student student = new Student("john@gmail.com", "John", "Dagger", "CS");
		Mockito.when(studentRepository.findById(student.getEmail())).thenReturn(Optional.ofNullable(null));
		Mockito.when(studentRepository.save(student)).thenReturn(student);
		Assertions.assertEquals(student, serviceImpl.saveStudent(student));

	}

	@Test
	public void saveStudentInValidTest() throws StudentServiceException {
		Student student = new Student("john@gmail.com", "John", "Dagger", "CS");
		Mockito.when(studentRepository.findById(student.getEmail())).thenReturn(Optional.of(student));
		Assertions.assertThrowsExactly(StudentServiceException.class, () -> serviceImpl.saveStudent(student));

	}

}
