package com.badar.muneer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.badar.muneer.model.Course;
import com.badar.muneer.repository.CourseRepository;

@Service
public class CourseServiceImp implements CourseService {

	@Autowired
	private CourseRepository courseRepository;
	@Override
	@Transactional
	public List<Course> getAll() 
	{
		return getCourseRepository().getAll();
	}
	
	@Override
	@Transactional
	public List<Course> getAllAvailable() 
	{
		List<Course> allAvailable = courseRepository.getAll();
		
		for(int i = 0; i < allAvailable.size(); i++)
		{
			if(!allAvailable.get(i).isAvailable())
			{
				allAvailable.remove(i); 
			}
		}
		return allAvailable;
	}
	
	@Override
	@Transactional
	public Course getCourse(long id) 
	{
		return courseRepository.getCourse(id);
	}
	public CourseRepository getCourseRepository() {
		return courseRepository;
	}
	public void setCourseRepository(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

}
