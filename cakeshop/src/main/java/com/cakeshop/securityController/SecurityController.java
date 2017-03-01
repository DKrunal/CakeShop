package com.cakeshop.securityController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cakeshop.dao.CategoryDAO;
import com.cakeshop.model.Category;



@Controller
public class SecurityController {
	Logger log = LoggerFactory.getLogger(SecurityController.class);


	@Autowired
	private HttpSession session;
	
	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private Category category;
	
	@RequestMapping(value="/accessDenied",method=RequestMethod.GET)
	public String accessDenied(Model model){
	log.debug("Starting Of the method access Denied");
	model.addAttribute("errorMessage", "you are not authorized to access this page");
	log.debug("Ending Of the method access Denied");
		return "accessDenied";
		
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request,HttpServletResponse response) {
		log.debug("Starting of the method logout");
		ModelAndView mv = new ModelAndView("/index");
	    session.invalidate();	// session
	    session =request.getSession(true);
		session.setAttribute("category", category);
		session.setAttribute("categoryList", categoryDAO.getCategory());

		mv.addObject("logoutMessage", "You successfully logged out");
		mv.addObject("loggedOut", "true");
		    
		log.debug("Ending of the method logout");
		return mv;
	}
	
	@RequestMapping(value="/loginError",method=RequestMethod.GET)
	public String loginError(Model model){
	log.debug("Starting Of the method loginError");
	model.addAttribute("errorMessage", "loginError");
	model.addAttribute("invalidCredentials", "true");
	log.debug("Ending Of the method loginError");
		return "index";
		
	}
}
