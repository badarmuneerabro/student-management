package com.badar.muneer.repository;

import java.util.List;

import com.badar.muneer.model.Course;

public interface CourseRepository 
{
	List<Course> getAll();

	List<Course> getAllAvailable();
	
	Course getCourse(long id);
	
	Course updateCourse(Course course);
}
