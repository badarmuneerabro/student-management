package com.badar.muneer.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
import com.badar.muneer.model.Course;
import com.badar.muneer.model.Student;
import com.badar.muneer.service.CourseService;
import com.badar.muneer.service.StudentService;

@Controller
@RequestMapping("/students") 
public class StudentController 
{
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/home")
	public ModelAndView studentHome(HttpServletRequest request, Model model)
	{
		HttpSession session = request.getSession();
		if(session.getAttribute("student") == null)
		{
			return new ModelAndView(new RedirectView("/login", true));
		}
		
		model.addAttribute("courses", courseService.getAllAvailable());
		return new ModelAndView("studentHome");
	}
	
	@GetMapping("/")
	public String allStudents(Model model, HttpSession session)
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
		student.setFirstName(s.getFirstName());
		student.setLastName(s.getLastName());
		student.setId(s.getId());
		student.setPhone(s.getPhone());
		student.setRollNo(s.getRollNo());
		
		model.addAttribute("student", student);
		
		return "updateStudent";
	}
	
	@PostMapping("/update-student")
	public ModelAndView updateStudent(@ModelAttribute("student") StudentForm studentForm)
	{
		Student student = new Student();
		
		student.setCountry(studentForm.getCountry());
		student.setFirstName(studentForm.getFirstName());
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
		st.setFirstName(student.getFirstName());
		st.setLastName(student.getLastName());
		st.setPhone(student.getPhone());
		st.setRollNo(student.getRollNo());
		
		if(student.getId() == null)
		{
			studentService.saveStudent(st);
		}
		
		else
		{
			st.setId(student.getId());
			studentService.update(st);
		}
		return new ModelAndView(new RedirectView("/students/", true));
	}
	
	@GetMapping("/delete-student/{id}")
	public ModelAndView deleteStudent(@PathVariable long id)
	{
		
		Student student = studentService.getStudent(id);
		
		studentService.delete(student);
		
		return new ModelAndView(new RedirectView("/students/", true));
	}
	
	
	@GetMapping("register-course/{id}")
	public ModelAndView registerForCourse(@PathVariable("id") long id, HttpSession session, Model model)
	{
		if(session.getAttribute("student") == null)
			return new ModelAndView(new RedirectView("/login", true));
		
		Student student = (Student) session.getAttribute("student");
		
		int totalCreditHours = 0;
		
		for(Course c : student.getCourses())
		{
			totalCreditHours = totalCreditHours + c.getCreditHours();
			
		}
		
		if(totalCreditHours >= 9)
		{
			model.addAttribute("registrationMsg", "Your total credit hours are completed.!");
			return new ModelAndView(new RedirectView("/home", true));
		}
		student.getCourses().add(courseService.getCourse(id));
		
		studentService.update(student);
		
		model.addAttribute("registrationMsg", "Registered in course successfull!");
		
		return new ModelAndView(new RedirectView("/home", true));
	}
	
	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}


	public CourseService getCourseService() {
		return courseService;
	}


	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
}
