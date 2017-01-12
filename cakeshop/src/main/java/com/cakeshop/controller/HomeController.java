package com.cakeshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cakeshop.dao.UserDAO;

@Controller
public class HomeController {
	
@RequestMapping("/")
	public String home(){
	
		return "index";
	}

@RequestMapping("/register")
public String signup(){
	
	return "Signup";
}

 @RequestMapping("/index")
public String index(){
	
	return "index";
}
}
