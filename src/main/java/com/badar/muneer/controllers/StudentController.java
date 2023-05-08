package com.badar.muneer.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.badar.muneer.dto.StudentForm;
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
		model.addAttribute("students", list);
		return "studentList";
	}

	
	@GetMapping("/add-student")
	public String addStudentPage(Model model)
	{
		model.addAttribute("student", new StudentForm());
		return "addStudent";
	}
	
	@GetMapping("/update-student/{id}")
	public String updateStudentPage(@PathVariable long id, Model model)
	{
		Student s = studentService.getStudent(id);
		StudentForm student = new StudentForm();
		
		student.setCountry(s.getCountry());
		student.setFirstName(s.getFirsName());
		student.setLastName(s.getLastName());
		student.setId(s.getId());
		student.setPhone(s.getPhone());
		student.setRollNo(s.getRollNo());
		
		model.addAttribute("student", student);
		
		return "addStudent";
	}
	
	@PostMapping("/update-student")
	public ModelAndView updateStudent(@ModelAttribute("student") StudentForm studentForm)
	{
		Student student = new Student();
		
		student.setCountry(studentForm.getCountry());
		student.setFirsName(studentForm.getFirstName());
		student.setLastName(studentForm.getLastName());
		student.setPhone(studentForm.getPhone());
		student.setRollNo(studentForm.getRollNo());
		student.setId(studentForm.getId());
		
		studentService.update(student);
		return new ModelAndView(new RedirectView("/students/", true));
	}
	@PostMapping("/add-student")
	public ModelAndView addStudent(@Valid @ModelAttribute("student")  StudentForm student, BindingResult result)
	{
		
		if(result.hasErrors())
		{
			return new ModelAndView("addStudent");
		}
		
		Student st = new Student();
		st.setCountry(student.getCountry());
		st.setFirsName(student.getFirstName());
		st.setLastName(student.getLastName());
		st.setPhone(student.getPhone());
		st.setRollNo(student.getRollNo());
		studentService.saveStudent(st);
		
		return new ModelAndView(new RedirectView("/students/", true));
	}
	
	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
}
