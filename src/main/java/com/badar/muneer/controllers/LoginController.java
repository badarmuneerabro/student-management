package com.badar.muneer.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.badar.muneer.dto.LoginForm;
import com.badar.muneer.model.Admin;
import com.badar.muneer.model.Student;
import com.badar.muneer.service.StudentService;

@Controller
public class LoginController 
{
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/login")
	public ModelAndView login(Model model, HttpSession session)
	{
		if(session.getAttribute("admin") == null && session.getAttribute("student") == null)
		{
			model.addAttribute("loginForm", new LoginForm());
			return new ModelAndView("login");
		}
		
		else if(session.getAttribute("admin") != null)
			return new ModelAndView(new RedirectView("/students/", true));
		
		else if(session.getAttribute("student") != null)
			return new ModelAndView(new RedirectView("/students/home", true));
		
		return new ModelAndView("login");
	}
	
	@PostMapping("/login")
	public ModelAndView login(@Valid @ModelAttribute("loginForm") LoginForm form,
			BindingResult result, Model model, HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		
		if(result.hasErrors())
		{
			return new ModelAndView("login");
		}
		String password = form.getPassword();
		String email = form.getEmail();
		if(email.equals("admin@system.com") && password.equals("admin"))
		{
			Admin admin = new Admin();
			session.setAttribute("admin", admin);
			request.changeSessionId();
			return new ModelAndView(new RedirectView("/students/", true));
		}
		
		System.out.println("Email: " + email + ",Password: " + password);
		Student student = studentService.getStudentWithEmailAndPassword(email, password);
		
		if(student == null)
		{
			System.out.println("Student is null");
			model.addAttribute("errorMsg", "Invalid Credentials");
			return new ModelAndView("login");
		}
		
		session.setAttribute("student", student);
		request.changeSessionId();
		
		return new ModelAndView(new RedirectView("/students/home", true)); 
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
}
