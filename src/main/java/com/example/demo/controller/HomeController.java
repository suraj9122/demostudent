package com.example.demo.controller;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.UserDetails;
import com.example.demo.model.UserUpdate;
import com.example.demo.service.UserService;

@RestController
public class HomeController {
	
	@Autowired
	private UserService userService;
	int uid;
	
	@RequestMapping("/home")
	public ModelAndView home(@ModelAttribute ("user")UserDetails user)
	
	{
	
		ModelAndView mv=new  ModelAndView("home.html");
		if(user.getId()!=0) {
			boolean f=userService.Update(user);
		}
		
		
		return mv;
	}
	
	@RequestMapping("/register")
	public ModelAndView register()
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("register.html");
		
		return mv;
	}
	@RequestMapping("/userdata")
	
	public ModelAndView userdata(@RequestParam("id")  int id,@RequestParam("password")  String pw,Model m)
	
	{
		System.out.println("hello");
		String msg ="";
      
	ModelAndView mv=new  ModelAndView();
	
	UserDetails use=userService.fetchuser(id);
		uid=id;
		mv.addObject("use", use);
		int sid=use.getId();
		String spw=use.getPassword();
			if (id ==sid && spw.equals(pw)) {
				mv.addObject(use);
				use.setId(id);
			
				
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
		
		ModelAndView mv=new  ModelAndView("home.html");
		
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

	@RequestMapping("/update")
	public ModelAndView update()
	{
		
	
	ModelAndView mv=new ModelAndView("update.html");
			
		return mv;
	
	}
	
	@RequestMapping("/addcourse")
	public ModelAndView addcourse()
	{
		
	
	ModelAndView mv=new ModelAndView("course.html");
	mv.clear();			
		return mv;
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//exception handling
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ModelAndView exp() {
		ModelAndView mv=new ModelAndView();
		
		mv.setViewName("error.html");
		mv.addObject("msg","id or password wrong");
		
		return mv;
				
	}

	@ExceptionHandler(java.sql.SQLIntegrityConstraintViolationException.class)
	public ModelAndView exp1() {
		ModelAndView mv=new ModelAndView();
		
		mv.setViewName("error.html");
		mv.addObject("msg","id or password wrong");
		
		return mv;
				
	}

}
