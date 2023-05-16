package com.badar.muneer.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "STUDENT", uniqueConstraints = @UniqueConstraint(columnNames = {"BATCH", "DEPT", "NUMBER", "EMAIL"}))
public class Student 
{
	private long id;
	
	private RollNo rollNo;
	private String firstName;
	private String lastName;
	private String country;
	private PhoneNo phone;
	
	private String email;
	private String password;
	
	private Set<Course> courses = new HashSet<>();
	
	@Id
	@Column(name = "STUDENT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Embedded
	public RollNo getRollNo() {
		return rollNo;
	}
	
	public void setRollNo(RollNo rollNo) {
		this.rollNo = rollNo;
	}
	
	@Column(name = "FIRST_NAME", length = 50)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "LAST_NAME", length = 50)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "COUNTRY", length = 50)
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Embedded
	public PhoneNo getPhone() {
		return phone;
	}
	public void setPhone(PhoneNo phone) {
		this.phone = phone;
	}
	
	@Column(name = "PASSWORD", length = 40)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "EMAIL", length = 60)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@ManyToMany(mappedBy = "students", cascade = {CascadeType.PERSIST})
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", rollNo=" + rollNo + ", firsName=" + firstName + ", lastName=" + lastName
				+ ", country=" + country + ", phone=" + phone + "]";
	}
	
	
}
