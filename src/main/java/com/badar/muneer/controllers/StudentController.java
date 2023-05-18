package com.badar.muneer.controllers;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.internal.build.AllowSysOut;
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
		
		Student student = (Student) session.getAttribute("student");
		List<Course> list = courseService.getAllAvailable();
		Set<Course> registeredCourses = student.getCourses();
		List<Course> filteredCourses = filterForStudent(list, registeredCourses);
		model.addAttribute("courses", filteredCourses);
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
		st.setEmail(student.getEmail());
		st.setPassword(student.getPassword());
		
		studentService.saveStudent(st);
		return new ModelAndView(new RedirectView("/students/", true));
	}
	
	@GetMapping("/delete-student/{id}")
	public ModelAndView deleteStudent(@PathVariable long id)
	{
		
		Student student = studentService.getStudent(id);
		Set<Course> courses = student.getCourses();
		student.setCourses(null);
		// iterate over courses, where student is registered.
		Iterator<Course> iterator = courses.iterator();
		boolean removed = false;
		while(iterator.hasNext())
		{
			Course course = iterator.next();
			Set<Student> students = course.getStudents();
			Iterator<Student> studentIterator = students.iterator();
			while(studentIterator.hasNext())
			{
				Student s = studentIterator.next();
				if(s.getId() == student.getId())
				{
					studentIterator.remove();
					courseService.updatCourse(course);
					
					removed = true;
					System.out.println("Removed from course");
					break;
				}
				
			}
		}
		
		studentService.delete(student);
		
		return new ModelAndView(new RedirectView("/students/", true));
	}
	
	@GetMapping("student-details/{id}")
	public ModelAndView studentDetails(@PathVariable("id") long id, Model model, HttpSession session)
	{
		if(session.getAttribute("admin") == null)
			return new ModelAndView(new RedirectView("/login", true));
		model.addAttribute("student", studentService.getStudent(id));
		
		return new ModelAndView("studentDetails");
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
			session.setAttribute("registrationMsg", "Your total credit hours are completed.!");
			return new ModelAndView(new RedirectView("/students/home", true));
		}
		Course course = courseService.getCourse(id);
		student.getCourses().add(course);
		
		studentService.update(student);
		course.getStudents().add(student);
		courseService.updatCourse(course);
		
		session.setAttribute("registrationMsg", "Registered in course successfull!");
		
		return new ModelAndView(new RedirectView("/students/home", true));
	}
	
	private List<Course> filterForStudent(List<Course> courses, Set<Course> coursesOfStudent)
	{
		Iterator<Course> iterator = coursesOfStudent.iterator();
		while(iterator.hasNext())
		{
			Course c = iterator.next();
			for(int j = 0; j < courses.size(); j++)
			{
				if(courses.get(j).getId() == c.getId())
				{
					courses.remove(j);
					break;
				}
			}
		}
		
		return courses;
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
