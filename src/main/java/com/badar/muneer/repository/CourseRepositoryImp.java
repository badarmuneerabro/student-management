package com.badar.muneer.repository;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.badar.muneer.model.Course;
import com.badar.muneer.model.Student;

@Repository
public class CourseRepositoryImp implements CourseRepository {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	
	public List<Course> getAll() 
	{
		Session session = getSessionFactory().getCurrentSession();

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

		CriteriaQuery<Course> query = criteriaBuilder.createQuery(Course.class);

		Root<Course> root = query.from(Course.class);

		query.select(root);

		Query<Course> createQuery = session.createQuery(query);

		return createQuery.getResultList();
	}
	
	@Override
	public List<Course> getAllAvailable() 
	{
		Session session = getSessionFactory().getCurrentSession();

		
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

		CriteriaQuery<Course> query = criteriaBuilder.createQuery(Course.class);

		Root<Course> root = query.from(Course.class);
		
		Predicate p = criteriaBuilder.equal(root.get("isAvailable"), 1);
		query.select(root).where(p);

		Query<Course> createQuery = session.createQuery(query);

		return createQuery.getResultList();
	}
	
	@Override
	public Course getCourse(long id) 
	{
		Session session = sessionFactory.getCurrentSession();
		Course course = session.get(Course.class, id);
		return course;
		
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
