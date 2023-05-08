package com.badar.muneer.repository;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.badar.muneer.model.Student;

@Repository
public class StudentRepositoryImp implements StudentRespository 
{

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Student> getAll() 
	{
		Session session = sessionFactory.getCurrentSession();
		
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		
		CriteriaQuery<Student> query = criteriaBuilder.createQuery(Student.class);
		
		Root<Student> root = query.from(Student.class);
		
		query.select(root);
		
		Query<Student> createQuery = session.createQuery(query);
		
		return createQuery.getResultList();
		
		
	}

	public Student getStudent(long id) 
	{
		Session session = sessionFactory.getCurrentSession();
		return session.get(Student.class, id);
	}
	public void saveStudent(Student student) 
	{
		Session session = sessionFactory.getCurrentSession();
		
		session.save(student);
	}

	public Student update(Student student) 
	{
		Session session = sessionFactory.getCurrentSession();
		Student oldStudent = session.get(Student.class, student.getId());
		oldStudent.setCountry(student.getCountry());
		oldStudent.setFirsName(student.getFirsName());
		oldStudent.setLastName(student.getLastName());
		oldStudent.setPhone(student.getPhone());
		oldStudent.setRollNo(student.getRollNo());
		
		session.update(oldStudent);
		
		return oldStudent; 
	}
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	

}
