package com.niit.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.entity.Student;
import com.niit.exception.StudentServiceException;
import com.niit.service.StudentService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
@Validated
public class StudentController {
	
	@Autowired
	public StudentService service;
	
	
	@PostMapping("/student")
	public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student) throws StudentServiceException {
		return  new ResponseEntity<Student>(service.saveStudent(student), HttpStatus.CREATED);
		
	}
	
	@GetMapping("/students")
	public ResponseEntity<?> getStudent() throws StudentServiceException {
//		List<Student> list=service.getAllStudents();
		return  new ResponseEntity<>(service.getAllStudents(), HttpStatus.OK);
		
	}
	
	@PutMapping("/student/{email}")
	public ResponseEntity<?> updateStudent(@Valid @RequestBody Student student,@Email(message = "{Please provide valid email address}")  @PathVariable String email) throws StudentServiceException {
		
		return  new ResponseEntity<>(service.updateStudent(student, email), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/student/{email}")
	public ResponseEntity<?> deleteStudent(@Email(message = "{Please provide valid email address}") @PathVariable String email) throws StudentServiceException {
		service.deleteStudent(email);
		return  new ResponseEntity<>(service.getAllStudents(), HttpStatus.OK);
		
	}

}
