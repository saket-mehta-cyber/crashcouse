package com.niit.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


@Entity
public class Student {
	
	@Id
	@Email(message = "{Please provide valid email address}")
	@NotNull(message = "{Please provide valid email address}")
	private String email;
	
	@NotNull(message="{Please provide valid first Name}")
	private String firstName;
	
	
	private String lastName;
	private String favSubject;
	
	public Student() {
		super();
	}

	public Student(String email, String firstName, String lastName, String favSubject) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.favSubject = favSubject;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFavSubject() {
		return favSubject;
	}

	public void setFavSubject(String favSubject) {
		this.favSubject = favSubject;
	}

	@Override
	public String toString() {
		return "Student [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", favSubject="
				+ favSubject + "]";
	}
	
	
	
	
	
	

}
