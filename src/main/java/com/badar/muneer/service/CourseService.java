package com.badar.muneer.service;

import java.util.List;

import com.badar.muneer.model.Course;

public interface CourseService 
{
	List<Course> getAll();
	
	List<Course> getAllAvailable();

}
