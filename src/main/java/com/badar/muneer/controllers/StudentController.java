package com.badar.muneer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.badar.muneer.model.Student;
import com.badar.muneer.service.StudentService;

@Controller
@RequestMapping("/students") 
public class StudentController 
{
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/")
	public String allStudents(Model model)
	{
		List<Student> list = studentService.getAll();
		System.out.println(list);
		model.addAttribute("students", list);
		return "studentList";
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
}
