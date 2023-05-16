package com.badar.muneer.service;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.badar.muneer.comparator.StudentComparator;
import com.badar.muneer.model.RollNo;
import com.badar.muneer.model.Student;
import com.badar.muneer.repository.StudentRespository;

@Service
public class StudentServiceImp implements StudentService 
{
	@Autowired
	private StudentRespository repository;

	@Transactional
	public List<Student> getAll() 
	{
		List<Student> list = repository.getAll();
		Collections.sort(list, new StudentComparator());
		return list;
	}

	@Transactional
	public Student getStudent(long id) 
	{
		return repository.getStudent(id);
	}
	
	
	
	@Transactional
	public void saveStudent(Student student) 
	{
		repository.saveStudent(student);
	}
	
	@Transactional
	public Student update(Student student) 
	{
		return repository.update(student);
	}

	@Transactional
	public void delete(Student student) 
	{
		repository.delete(student);
	}
	
	@Override
	@Transactional
	public Student getStudentWithEmailAndPassword(String email, String password) 
	{
		return repository.getStudentWithEmailAndPassword(email, password);
	}
	public StudentRespository getRespository() {
		return repository;
	}

	public void setRespository(StudentRespository repository) {
		System.out.println("Repository created...");
		this.repository = repository;
	}

	

	

}
