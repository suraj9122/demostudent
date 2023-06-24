package com.example.demo.controller;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.UserDetails;
import com.example.demo.service.UserService;

@RestController
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/home")
	public ModelAndView home()
	{
		
		ModelAndView mv1=new  ModelAndView("home.html");
		return mv1;
	}
	
	@RequestMapping("/register")
	public ModelAndView register()
	{
		ModelAndView mv2=new ModelAndView();
		mv2.addObject("register.html");
		
		return mv2;
	}
	@RequestMapping("/userdata")
	public ModelAndView userdata(@RequestParam("id")  int id,@RequestParam("password")  String pw,Model m)
	
	{
		
		String msg ="";
      
	ModelAndView mv=new  ModelAndView();
		UserDetails use=userService.fetchuser(id);
		mv.addObject("use", use);
		int sid=use.getId();
		String spw=use.getPassword();
			if (id ==sid && spw.equals(pw)) {
				mv.addObject(use);
				mv.addObject("userdata.html");
	            return mv; // Return the name of your home HTML template
	        } 
			
			else
			{
				mv.setViewName("home.html");
			}
			
			
	            return mv; // Return the name of your login HTML template
	        
		
	}
	@RequestMapping("/createuser")
	public ModelAndView createuser(@ModelAttribute ("user")UserDetails user,HttpSession session)
	{
		//@RequestParam("name")  String nm,@RequestParam("address")  String ad,@RequestParam("contact")  String ct,@RequestParam("email")  String em,@RequestParam("course")  String c
		//System.out.println(nm);
	//	System.out.println(ad);
	//	System.out.println(ct);
   //System.out.println(em);
		ModelAndView mv=new  ModelAndView("redirect:/register");
		
		boolean f=userService.checkEmail(user.getEmail());
		
	
		if (f)
		{
			mv.addObject("msg", "email id already exit");
		}
		else
		{
		UserDetails use=userService.createUser(user);
		if(use!=null) {
			mv.addObject("msg", "registered successfully");}
		else {
			mv.addObject("msg","something wrong on server");
		}
		}
		
		
		return mv;
	}


	@ExceptionHandler(EntityNotFoundException.class)
	public ModelAndView exp() {
		ModelAndView mv=new ModelAndView();
		
		mv.setViewName("error.html");
		mv.addObject("msg","id or password wrong");
		
		return mv;
				
	}

}
