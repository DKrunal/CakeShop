package com.cakeshop.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cakeshop.dao.CategoryDAO;
import com.cakeshop.dao.ProductDAO;
import com.cakeshop.dao.SupplierDAO;
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
	private Category category;

	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private Supplier supplier;

	@Autowired
	private Product product;
	
	@Autowired
	private ProductDAO productDAO;

	/*@RequestMapping("/loginHere")
	public ModelAndView loginHere() {
		log.debug("Starting of the method loginHere");
		System.out.println("loginHere");
		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("user", user);
		mv.addObject("isUserClickedLoginHere", "true");
		log.debug("Ending of the method loginHere");
		return mv;
	}*/
@RequestMapping("/")
	public ModelAndView onLoad(HttpSession session){
	
	log.debug("Starting of the method onLoad");
	ModelAndView mv = new ModelAndView("/index");
	session.setAttribute("category", category);
	session.setAttribute("product", product);
	session.setAttribute("supplier", supplier);
	
	
	session.setAttribute("categoryList", categoryDAO.getCategory());
	
	session.setAttribute("supplierList", supplierDAO.getSuppliers());

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


 @RequestMapping("index")
public String index(@ModelAttribute("selectedProduct") final Product selectedProduct, final Model model){
	
	 log.debug("Starting of the method reDirectToHome");
		model.addAttribute("selectedProduct", selectedProduct);
	 model.addAttribute("categoryList", this.categoryDAO.getCategory());
	    model.addAttribute("productList", this.productDAO.getProduct());
		log.debug("Ending of the method reDirectToHome");
		return "index";
	}
}

 
 

