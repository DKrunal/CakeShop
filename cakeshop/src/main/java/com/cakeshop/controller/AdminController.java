package com.cakeshop.controller;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cakeshop.dao.CategoryDAO;
import com.cakeshop.dao.ProductDAO;
import com.cakeshop.dao.SupplierDAO;
import com.cakeshop.model.Category;
import com.cakeshop.model.Product;
import com.cakeshop.model.Supplier;


@Controller
public class AdminController {
	private static Logger log = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	private Product product;

	@Autowired
	private Supplier supplier;

	@Autowired
	private Category category;
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private HttpSession session;

	
	@RequestMapping("Category")
	public ModelAndView categories() {
		log.debug("Starting of the method categories");
		ModelAndView mv = new ModelAndView("index");
		
		String loggedInUser=(String)session.getAttribute("loggedInUser");
		log.info("LoggedInUser Is: "+loggedInUser);
		mv.addObject("isAdmin", "true");

		mv.addObject("category", category);
		mv.addObject("isAdminClickedCategories", "true");
		mv.addObject("categoryList", categoryDAO.getCategory());
		log.debug("Ending of the method categories");
		return mv;
	}

	@RequestMapping("Product")
	public ModelAndView products() {
		log.debug("Starting of the method products");
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isAdmin", "true");
		mv.addObject("isAdminClickedProducts", "true");
		mv.addObject("product", product);
		mv.addObject("productList", productDAO.getProduct());
		mv.addObject("category", category);
		mv.addObject("categoryList", categoryDAO.getCategory());
		mv.addObject("supplier", supplier);
		mv.addObject("supplierList", supplierDAO.getSuppliers());
		log.debug("Ending of the method products");
		return mv;
	}

	@RequestMapping("Supplier")
	public ModelAndView suppliers() {
		log.debug("Starting of the method suppliers");
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("supplier", supplier);
		mv.addObject("isAdmin", "true");

		mv.addObject("isAdminClickedSuppliers", "true");
		mv.addObject("supplierList", supplierDAO.getSuppliers());
		log.debug("Ending of the method suppliers");
		return mv;
	}

}

