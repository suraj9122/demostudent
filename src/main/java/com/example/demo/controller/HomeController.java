package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.UserDetails;
import com.example.demo.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
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
	public String userdata( )
	
	{
		
		
		return"userdata.html";
	}
	
	@PostMapping("/createuser")
	public String createuser(@ModelAttribute("user")UserDetails user)
	{
		//@RequestParam("name")  String nm,@RequestParam("address")  String ad,@RequestParam("contact")  String ct,@RequestParam("email")  String em,@RequestParam("course")  String c
		//System.out.println(nm);
	//	System.out.println(ad);
	//	System.out.println(ct);
   //System.out.println(em);
	System.out.println(user);
		userService.createUser(user);
		return"home.html";
	}

}
