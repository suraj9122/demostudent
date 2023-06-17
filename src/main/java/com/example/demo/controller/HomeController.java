package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/home")
	public String home()
	{
		
		
		return"home.html";
	}
	
	@RequestMapping("/register")
	public String register()
	{
		
		
		return"register.html";
	}
	@RequestMapping("/userdata")
	public String userdata()
	{
		
		
		return"userdata.html";
	}
	

}
