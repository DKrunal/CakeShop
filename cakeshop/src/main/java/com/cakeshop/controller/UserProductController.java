package com.cakeshop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cakeshop.dao.CategoryDAO;
import com.cakeshop.dao.ProductDAO;
import com.cakeshop.dao.SupplierDAO;
import com.cakeshop.model.Category;
import com.cakeshop.model.Product;
import com.cakeshop.model.Supplier;
import com.cakeshop.model.User;

@Controller
public class UserProductController {
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

	 @RequestMapping("/userShop/{selectedCategory}")
	 public String userProduct(@PathVariable("selectedCategory")String  selectedCategory, Model model){
		 	log.debug("Starting of the method userShop");
	category = categoryDAO.getCategoryByName(selectedCategory);
	 	log.debug("Ending of the method userShop");
		return "redirect:/user_products";
	 }
	 
	 @RequestMapping(value = "/user_products", method = RequestMethod.GET)
		public String listProducts(Model model) {
			log.debug(" Starting of the method listProducts");
			 model.addAttribute("isUserClickShop", "true");
			model.addAttribute("category", category);
	        model.addAttribute("categoryList", categoryDAO.getCategory());
	        model.addAttribute("product", product);
			model.addAttribute("productList", productDAO.getProductByCategoryName(category.getCategory_id()));
	        model.addAttribute("supplier", supplier);
	        model.addAttribute("supplierList", supplierDAO.getSuppliers());
	        
			log.debug(" End of the method listProducts");
			return "/index";
		} 
	 
	 
	 @RequestMapping(value= "selectedProduct/{product_id}")
	 public String selectedProduct(@PathVariable("product_id")String selectedProduct, Model model){
		 log.debug("Starting of the method selectedProduct");
		 product = productDAO.getProductById(selectedProduct);
		 log.debug("End of the method selectedProduct");
		return "redirect:/selected_products";
	 }
	 
	 @RequestMapping(value = "/selected_products", method = RequestMethod.GET)
		public String selectedProduct(Model model) {
			log.debug(" Starting of the method selectedProduct");
			model.addAttribute("isUserSelectProduct", "true");
			model.addAttribute("category", category);
	        model.addAttribute("categoryList", categoryDAO.getCategory());
	        model.addAttribute("product", product);
			model.addAttribute("productList", productDAO.getProductByCategoryName(category.getCategory_id()));
	        model.addAttribute("supplier", supplier);
	        model.addAttribute("supplierList", supplierDAO.getSuppliers());
	        
			log.debug(" End of the method selectedProduct");
			return "/index";
		} 
}
