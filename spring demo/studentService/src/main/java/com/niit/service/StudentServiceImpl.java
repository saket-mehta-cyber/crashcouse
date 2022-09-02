package com.niit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.entity.Student;
import com.niit.exception.StudentServiceException;
import com.niit.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	public StudentRepository studentRepository;
	
	@Override
	public Student saveStudent(Student student) throws StudentServiceException {
		Optional<Student> getStudent=studentRepository.findById(student.getEmail());
		if(getStudent.isPresent()) {
		
			throw new StudentServiceException("Student email-id already exist");
		}
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudents() throws StudentServiceException {
		return studentRepository.findAll();
	}

	@Override
	public Student updateStudent(Student student, String email) throws StudentServiceException {
		Optional<Student> getStudent =studentRepository.findById(email);
		if(getStudent.isEmpty()) {
			throw new StudentServiceException("Student does not exist");
		}
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudent(String email) throws StudentServiceException {
		Optional<Student> getStudent =studentRepository.findById(email);
		if(getStudent.isEmpty()) {
			throw new StudentServiceException("Student does not exist");
		}
		studentRepository.deleteById(email);
		
	}

	
}
