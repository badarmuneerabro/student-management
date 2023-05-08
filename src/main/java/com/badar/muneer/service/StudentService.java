package com.badar.muneer.service;

import java.util.List;

import com.badar.muneer.model.Student;

public interface StudentService 
{

	List<Student> getAll();
	
	Student getStudent(long id);
	
	void saveStudent(Student student);

	Student update(Student student);

	void delete(Student student);
}
