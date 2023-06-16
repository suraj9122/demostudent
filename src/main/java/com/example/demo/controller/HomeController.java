package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/homme")
	public String home()
	{
		
		System.out.println("0");
		return"home.html";
	}

}
