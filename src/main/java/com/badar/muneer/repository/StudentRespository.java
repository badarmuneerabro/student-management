package com.badar.muneer.repository;

import java.util.List;

import com.badar.muneer.model.Student;

public interface StudentRespository 
{

	List<Student> getAll();
	Student getStudent(long id);
}
