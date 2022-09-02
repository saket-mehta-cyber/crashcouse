package com.niit.service;

import java.util.List;

import com.niit.entity.Student;
import com.niit.exception.StudentServiceException;

public interface StudentService {

	Student saveStudent(Student student) throws StudentServiceException;
	List<Student> getAllStudents() throws StudentServiceException;
	Student updateStudent(Student student,String email) throws StudentServiceException;
	void deleteStudent(String email) throws StudentServiceException;
}
