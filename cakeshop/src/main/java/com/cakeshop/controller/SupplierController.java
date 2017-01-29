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

import com.cakeshop.dao.SupplierDAO;
import com.cakeshop.model.Supplier;

@Controller
public class SupplierController {

	private static Logger log = LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	private Supplier supplier;
	
	@RequestMapping(value = "/manage_supplier_add", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("supplier") Supplier supplier, Model model) {
		log.debug(" Starting of the method addSupplier");

		log.debug("id:" + supplier.getSupplier_id());
		if (supplierDAO.saveOrUpdate(supplier) == true) {
			
			model.addAttribute("msg", "Successfully created/updated the caetgory");
		} else {
			model.addAttribute("msg", "not able created/updated the caetgory");
		}
		model.addAttribute("supplier", supplier);
		model.addAttribute("supplierList", supplierDAO.getSuppliers());
		model.addAttribute("isAdminClickedSuppliers", "true");
		log.debug(" Ending of the method addSupplier");
		return "/index";
	}
	
	@RequestMapping("manage_supplier_remove/{supplier_id}")
	public String deleteSupplier(@PathVariable("supplier_id") String supplier_id, Model model) throws Exception {

		boolean flag = supplierDAO.delete(supplier_id);

		String msg = "Successfully done the operation";
		if (flag != true) {
			msg = "The operation could not success";
		}
		
		 model.addAttribute("supplier", supplier);
		  model.addAttribute("supplierList", this.supplierDAO.getSuppliers());
		 
		model.addAttribute("msg", msg);

		return "redirect:/manage_suppliers";
	}

	
	@RequestMapping("manage_supplier_edit/{supplier_id}")
	public String editSupplier(@PathVariable("supplier_id") String supplier_id, Model model) {
		log.debug(" Starting of the method editCategory"+supplier.getContact());
		supplier = supplierDAO.getSupplierById(supplier_id);
		model.addAttribute("supplier", supplier);
		log.debug(" End of the method editSupplier");
		return "redirect:/manage_suppliers";
	}
	
	@RequestMapping(value = "/manage_suppliers", method = RequestMethod.GET)
	public String listSuppliers(Model model) {
		log.debug(" Starting of the method listSuppliers");
		model.addAttribute("supplier", supplier);
		model.addAttribute("supplierList", supplierDAO.getSuppliers());
		model.addAttribute("isAdminClickedSuppliers", "true");
		log.debug(" End of the method listSuppliers");
		return "/index";
	}
	
}
