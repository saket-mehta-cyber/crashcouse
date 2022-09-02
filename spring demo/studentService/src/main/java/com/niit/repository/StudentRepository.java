package com.niit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niit.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

}
