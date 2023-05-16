package com.badar.muneer.dto;

import javax.validation.constraints.NotBlank;

import com.badar.muneer.model.RollNo;

public class LoginForm 
{
	
	@NotBlank(message = "*Email is required")
	private String email;
	
	@NotBlank(message = "*Password is required")
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
