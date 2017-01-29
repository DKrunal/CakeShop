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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cakeshop.dao.CategoryDAO;
import com.cakeshop.dao.ProductDAO;
import com.cakeshop.dao.SupplierDAO;
import com.cakeshop.model.Category;
import com.cakeshop.model.Product;
import com.cakeshop.model.Supplier;
import com.cakeshop.util.FileUtil;

@Controller
public class ProductController {
	private static Logger log = LoggerFactory.getLogger(CategoryController.class);
	@Autowired
	private Category category;
	
	@Autowired
	private Supplier supplier;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private Product product;
	
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private SupplierDAO supplierDAO;
	
	private String path ="F:\\Digital Transformation\\New folder\\img\\";
	@RequestMapping(value="/manage_product_add", method=RequestMethod.POST)
	public String addProduct(@ModelAttribute("product")Product product,@RequestParam("image")MultipartFile file,Model model){
		Category category = categoryDAO.getCategoryByName(product.getCategory().getName());
		
		Supplier supplier = supplierDAO.getSupplierByName(product.getSupplier().getName());
		product.setCategory(category);
		product.setSupplier(supplier);
		
		product.setCategory_id(category.getCategory_id());
		product.setSupplier_id(supplier.getSupplier_id());
	if (productDAO.saveOrUpdate(product) == true) {
			log.debug("Successfully created/updated the Product");
			model.addAttribute("msg", "Successfully created/updated the Product");
		} else {
			log.debug("Successfully  not created/updated the Product");

			model.addAttribute("msg", "not able created/updated the Product");
		}
		model.addAttribute("product", product);
		model.addAttribute("productList", productDAO.getProduct());
		model.addAttribute("category", category);
        model.addAttribute("categoryList", categoryDAO.getCategory());
        model.addAttribute("supplier", supplier);
        model.addAttribute("supplierList", supplierDAO.getSuppliers());
		model.addAttribute("isAdminClickedProducts", "true");
		FileUtil.upload(path, file, product.getProduct_id()+".jpg");
		return "/index";
	}
	
	/*@RequestMapping(value = "/manage_product_add", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") Product product, Model model) {
		log.debug(" Starting of the method addProduct");

		log.debug("id:" + product.getId());
		if (productDAO.saveOrUpdate(product) == true) {
			
			model.addAttribute("msg", "Successfully created/updated the Product");
		} else {
			model.addAttribute("msg", "not able created/updated the Product");
		}
		model.addAttribute("product", product);
		model.addAttribute("productList", productDAO.getProduct());
		model.addAttribute("isAdminClickedProduct", "true");
		log.debug(" Ending of the method addProduct");
		return "/Product";
	}*/
	
	@RequestMapping("manage_product_remove/{product_id}")
	public String deleteProduct(@PathVariable("product_id") String product_id, Model model) throws Exception {

		boolean flag = productDAO.delete(product_id);

		String msg = "Successfully done the operation";
		if (flag != true) {
			msg = "The operation could not success";
		}
		model.addAttribute("msg", msg);

		return "redirect:/manage_products";
	}
	
	@RequestMapping("manage_product_edit/{product_id}")
	public String editProduct(@PathVariable("product_id") String product_id, Model model) {
		log.debug(" Starting of the method editCategory"+product.getDescription());
        product = productDAO.getProductById(product_id);
        model.addAttribute("product", product);
		log.debug(" End of the method editProduct");
		return "redirect:/manage_products";
	}
	@RequestMapping(value = "/manage_products", method = RequestMethod.GET)
	public String listProducts(Model model) {
		log.debug(" Starting of the method listProducts");
		model.addAttribute("product", product);
		
        model.addAttribute("productList", productDAO.getProduct());
        model.addAttribute("category", category);
        model.addAttribute("categoryList", categoryDAO.getCategory());
        model.addAttribute("supplier", supplier);
        model.addAttribute("supplierList", supplierDAO.getSuppliers());
		model.addAttribute("isAdminClickedProducts", "true");
		log.debug(" End of the method listProducts");
		return "/index";
	}
}


