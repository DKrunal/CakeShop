package com.cakeshop.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cakeshop.dao.CartDAO;
import com.cakeshop.dao.CategoryDAO;
import com.cakeshop.dao.ProductDAO;
import com.cakeshop.dao.SupplierDAO;
import com.cakeshop.dao.UserDAO;
import com.cakeshop.model.Category;
import com.cakeshop.model.Product;
import com.cakeshop.model.Supplier;
import com.cakeshop.model.User;

@Controller
public class HomeController {
	
	Logger log = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	User user;

	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private CartDAO cartDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private Category category;

	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private Supplier supplier;

	@Autowired
	private Product product;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private HttpSession session;

	@RequestMapping("/Login")
	public ModelAndView loginHere() {
		log.debug("Starting of the method loginHere");
		System.out.println("loginHere");
		ModelAndView mv = new ModelAndView("/LogIn");
		mv.addObject("user", user);
		mv.addObject("isUserClickedLoginHere", "true");
		log.debug("Ending of the method loginHere");
		return mv;
	}
	

@RequestMapping("/")
	public ModelAndView onLoad(Principal principal){
	
	log.debug("Starting of the method onLoad");
	ModelAndView mv = new ModelAndView("/index");
	session.setAttribute("category", category);
	session.setAttribute("product", product);
	session.setAttribute("supplier", supplier);
	session.setAttribute("categoryList", categoryDAO.getCategory());
	session.setAttribute("supplierList", supplierDAO.getSuppliers());
	int n=0;
	try {
		//log.debug("User - "+SecurityContextHolder.getContext().getAuthentication().getName());
		log.debug("User - "+principal.getName());

		String name = principal.getName();
		n = cartDAO.userCartList(name).size();
	} catch (Exception e) {
		e.printStackTrace();
	}
	session.setAttribute("cartSize",n);
	try 
	{
		String name = principal.getName();
		session.setAttribute("mail_id", name);
		user = userDAO.getUserById(name);
		log.debug("User mail id- " + session.getAttribute("mail_id"));
   //  if(name!="anonymousUser"){
		session.setAttribute("user_f_name", user.getFname());
		session.setAttribute("user", user);
   //  }else{
    //	 session.setAttribute("user_f_name", "anonymousUser");
   //  }
		log.debug("User user_f_name - " + session.getAttribute("user_f_name"));
	}

	catch (Exception e) 
	{
		e.printStackTrace();
		log.info("User has not yet logged in"+e.getMessage());
//		System.out.println("Null.");
	}
	log.debug("Ending of the method onLoad");
	return mv;

	}

@RequestMapping("/register")
public ModelAndView signup(){
	log.debug("Starting of the method registerHere");
	ModelAndView mv = new ModelAndView("Signup");
	mv.addObject("user", user);
	mv.addObject("isUserClickedRegisterHere", "true");
	log.debug("Ending of the method registerHere");
	return mv;
}

@RequestMapping("/cancelEvent")
public ModelAndView cancelEvent(){
	log.debug("Starting of the method cancelEvent");
	ModelAndView mv = new ModelAndView("/index");
	mv.addObject("user", user);
	log.debug("Ending of the method cancelEvent");
	return mv;
}

 @RequestMapping("/index")
public String index(@ModelAttribute("selectedProduct") final Product selectedProduct, final Model model){
	
	 log.debug("Starting of the method reDirectToHome");
		model.addAttribute("selectedProduct", selectedProduct);
	    model.addAttribute("categoryList", this.categoryDAO.getCategory());
	    log.info("categoryList",categoryDAO.getCategory());
	    model.addAttribute("productList", this.productDAO.getProduct());
		log.debug("Ending of the method reDirectToHome");
		return "/index";
	}
 

}


 
 

