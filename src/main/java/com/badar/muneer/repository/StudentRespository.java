package com.badar.muneer.repository;

import java.util.List;

import com.badar.muneer.model.RollNo;
import com.badar.muneer.model.Student;

public interface StudentRespository 
{

	List<Student> getAll();
	Student getStudent(long id);
	void saveStudent(Student student);
	Student update(Student student);
	void delete(Student student);
	
	Student getStudentWithEmailAndPassword(String email, String password);
}
