package com.badar.muneer.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.badar.muneer.model.Course;
import com.badar.muneer.model.PhoneNo;
import com.badar.muneer.model.RollNo;

public class StudentForm 
{
	
	private Long id;
	
	@NotBlank(message = "* First name is required")
	private String firstName;
	
	@NotBlank(message = "* Last name is required")
	private String lastName;
	
	@NotBlank(message = "* Country is required")
	private String country;
	
	@Valid
	private PhoneNo phone;
	
	
	private RollNo rollNo;
	
	@NotBlank(message = "*Email is required")
	private String email;
	@NotBlank(message = "*Password is required")
	private String password;
	
	private Set<Course> courses = new HashSet<>();
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public PhoneNo getPhone() {
		return phone;
	}
	public void setPhone(PhoneNo phone) {
		this.phone = phone;
	}
	public RollNo getRollNo() {
		return rollNo;
	}
	public void setRollNo(RollNo rollNo) {
		this.rollNo = rollNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
	
	
}
