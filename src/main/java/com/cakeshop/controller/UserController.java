package com.cakeshop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cakeshop.dao.CategoryDAO;
import com.cakeshop.dao.SupplierDAO;
import com.cakeshop.dao.UserDAO;
import com.cakeshop.model.Category;
import com.cakeshop.model.Supplier;
import com.cakeshop.model.User;

@Controller
public class UserController {
	public static Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private User user;

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private Category category;

	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private Supplier supplier;

	@Autowired
	private HttpSession session;

	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public ModelAndView validate(@RequestParam(value = "id") String id,
			@RequestParam(value = "password") String password) {
		log.debug("Starting of the method validate");
		ModelAndView mv = new ModelAndView("/index");
		user = userDAO.isValid(id, password);
		// if the record exist with this userID and password it will return user
		// details else will return null

		if (user != null) {
			log.debug("Valid Credentials");

			session.setAttribute("loggedInUser", user.getFname());
			session.setAttribute("loggedInUserID", user.getId());

			session.setAttribute("user", user); //

			if (user.getRole().equals("ROLE_ADMIN")) {
				log.debug("Logged in as Admin");
				mv.addObject("isAdmin", "true");
				session.setAttribute("isAdmin", "true");
				session.setAttribute("supplier", supplier);
				session.setAttribute("supplierList", supplierDAO.getSuppliers());

				session.setAttribute("category", category);
				session.setAttribute("categoryList", categoryDAO.getCategory());

			} else {
				log.debug("Logged in as User");
				mv.addObject("isAdmin", "false");
			}

		} else {
			log.debug("Invalid Credentials");
			System.out.println("inValid Credential");
			mv.addObject("invalidCredentials", "true");
			mv.addObject("errorMessage", "Invalid Credentials");

		}
		log.debug("Ending of the method validate");
		return mv;
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signup(@ModelAttribute User user) {
		log.debug("Starting of the method registerUser");
		System.out.println("Starting of the method registerUser"+user.getId());
		ModelAndView mv = new ModelAndView("/index");
		if (userDAO.getUserById(user.getId()) == null) {
			user.setRole("ROLE_USER");
			userDAO.save(user);
			log.debug("You are successfully register");
		} else {
			log.debug("User exist with this id");
		}
		log.debug("Ending of the method registerUser");
		return mv;
	}
	
	@RequestMapping("/logOut")
	public ModelAndView logout(HttpServletRequest request,HttpServletResponse response) {
		log.debug("Starting of the method logout");
		ModelAndView mv = new ModelAndView("/index");
	    session.invalidate();	// session
	    session =request.getSession(true);
		session.setAttribute("category", category);
		session.setAttribute("categoryList", categoryDAO.getCategory());

		mv.addObject("logoutMessage", "You successfully logged out");
		mv.addObject("loggedOut", "true");
		
		/* Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		    if (auth != null){    
		        new SecurityContextLogoutHandler().logout(request, response, auth);
		    }
		  //  return "redirect:/login?logout";
		    */
		    
		log.debug("Ending of the method logout");
		return mv;
	}
}
