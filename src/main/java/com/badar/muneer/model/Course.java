package com.badar.muneer.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "COURSES", uniqueConstraints = @UniqueConstraint(columnNames = "CODE"))
public class Course 
{
	private long id;
	private String name;
	private String code;
	private short creditHours;
	private boolean isAvailable;
	
	private Set<Student> students = new HashSet<>();

	@Id
	@Column(name = "COURSE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "NAME", length = 40)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "CODE", length = 10)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "CREDIT_HOURS", length = 5)
	public short getCreditHours() {
		return creditHours;
	}

	public void setCreditHours(short creditHours) {
		this.creditHours = creditHours;
	}
	
	@Column(name = "IS_AVAILABLE")
	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@ManyToMany
	@JoinTable(
			name = "STUDENTS_COURSES",
			joinColumns = @JoinColumn(referencedColumnName = "COURSE_ID"),
			inverseJoinColumns = @JoinColumn(referencedColumnName = "STUDENT_ID")
			)
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
}
