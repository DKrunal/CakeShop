package com.cakeshop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cakeshop.dao.CategoryDAO;
import com.cakeshop.model.Category;

@Controller
public class CategoryController {

	private static Logger log = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private Category category;
	
	@RequestMapping(value = "/manage_category_add", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("category") Category category, Model model) {
		log.debug(" Starting of the method addCategory");

		log.debug("id:" + category.getCategory_id());
		if (categoryDAO.saveOrUpdate(category) == true) {
			
			model.addAttribute("msg", "Successfully created/updated the caetgory");
		} else {
			model.addAttribute("msg", "not able created/updated the caetgory");
		}
		model.addAttribute("category", category);
		model.addAttribute("categoryList", categoryDAO.getCategory());
		model.addAttribute("isAdminClickedCategories", "true");
		log.debug(" Ending of the method addCategory");
		return "/index";
	}
	@RequestMapping("manage_category_remove/{category_id}")
	public String deleteCategory(@PathVariable("category_id") String category_id, Model model) throws Exception {

		boolean flag = categoryDAO.delete(category_id);

		String msg = "Successfully done the operation";
		if (flag != true) {
			msg = "The operation could not success";
		}
		
		 model.addAttribute("category", category);
		  model.addAttribute("categoryList", this.categoryDAO.getCategory());
		 
		model.addAttribute("msg", msg);

		return "redirect:/manage_categories";
	}

	@RequestMapping("manage_category_edit/{category_id}")
	public String editCategory(@PathVariable("category_id") String category_id, Model model) {
		log.debug(" Starting of the method editCategory"+category.getDescription());

	  // categoryDAO.saveOrUpdate(category);
		category = categoryDAO.getCategoryById(category_id);

		model.addAttribute("category", category);
		log.debug(" End of the method editCategory");
		return "redirect:/manage_categories";
	}
	@RequestMapping(value = "/manage_categories", method = RequestMethod.GET)
	public String listCategories(Model model) {
		log.debug(" Starting of the method listCategories");
		model.addAttribute("category", category);
		model.addAttribute("categoryList", categoryDAO.getCategory());
		model.addAttribute("isAdminClickedCategories", "true");
		log.debug(" End of the method listCategories");
		return "/index";
	}
}
