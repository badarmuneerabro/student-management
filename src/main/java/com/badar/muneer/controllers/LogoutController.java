package com.badar.muneer.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller 
public class LogoutController 
{

	@GetMapping("/logout")
	public ModelAndView logout(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		
		if(session.getAttribute("student") != null || session.getAttribute("admin") != null)
		{
			session.invalidate();
			
		}
		
		return new ModelAndView(new RedirectView("/login", true));
	}
}
