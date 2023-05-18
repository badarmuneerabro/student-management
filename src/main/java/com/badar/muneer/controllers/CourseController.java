package com.badar.muneer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.badar.muneer.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController 
{
	@Autowired
	private CourseService courseService;
	@GetMapping("/all-courses")
	public String allCourses(Model model)
	{
		model.addAttribute("courses", courseService.getAll());
		return "allCourses";
	}
	public CourseService getCourseService() {
		return courseService;
	}
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
}
