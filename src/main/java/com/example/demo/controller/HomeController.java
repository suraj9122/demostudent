package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	public String userdata(@RequestParam("id")  int id,@RequestParam("password")  String pw,Model m)
	
	{
		
		String username = "John Doe";
       // m.addAttribute("username", username);
	// ModelAndView model=new ModelAndView("userdata.html");
		UserDetails use=userService.fetchuser(id);
		m.addAttribute("use",use);
		 //model.addObject("use",use);
		
		//session.setAttribute("msg","something wrong on server");
		// System.out.print(model);
		/*if(id==use.getId())
		{
			if(pw.equals(use.getPassword()))
			{
			
				
			}
			else
				model.addAttribute(pw, use)
		}
		else
			session.setAttribute("msg", "id wrong");
		
	}*/
		 return "userdata";
	}
	@RequestMapping("/createuser")
	public String createuser(@ModelAttribute ("user")UserDetails user,HttpSession session)
	{
		//@RequestParam("name")  String nm,@RequestParam("address")  String ad,@RequestParam("contact")  String ct,@RequestParam("email")  String em,@RequestParam("course")  String c
		//System.out.println(nm);
	//	System.out.println(ad);
	//	System.out.println(ct);
   //System.out.println(em);
		
		boolean f=userService.checkEmail(user.getEmail());
		
	
		if (f)
		{
			session.setAttribute("msg", "email id already exit");
		}
		else
		{
		UserDetails use=userService.createUser(user);
		if(use!=null) {
		session.setAttribute("msg", "registered successfully");}
		else {
			session.setAttribute("msg","something wrong on server");
		}
		}
		
		return"redirect:/register";
	}

}
