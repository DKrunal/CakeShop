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
	private ProductDAO productDAO;
	
	@Autowired
	private Product product;
	
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private SupplierDAO supplierDAO;
	
	private String path ="F:\\Digital Transformation\\portal\\img";
	@RequestMapping(value="/product/add", method=RequestMethod.POST)
	public String addProduct(@ModelAttribute("product")Product product,@RequestParam("image")MultipartFile file){
		Category category = categoryDAO.getCategoryByName(product.getCategory().getName());
		
		Supplier supplier = supplierDAO.getSupplierByName(product.getSupplier().getName());
		product.setCategory(category);
		product.setSupplier(supplier);
		
		product.setCategory_id(category.getId());
		product.setSupplier_id(supplier.getId());
		productDAO.saveOrUpdate(product);
		FileUtil.upload(path, file, product.getId()+".jpg");
		return "Product";
	}
	
	@RequestMapping(value = "/manage_product_add", method = RequestMethod.POST)
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
	}
	
	@RequestMapping("manage_product_remove/{id}")
	public String deleteProduct(@PathVariable("id") String id, Model model) throws Exception {

		boolean flag = productDAO.delete(id);

		String msg = "Successfully done the operation";
		if (flag != true) {
			msg = "The operation could not success";
		}
		model.addAttribute("msg", msg);

		return "forward:/manage_products";
	}
	
	@RequestMapping("manage_product_edit/{id}")
	public String editProduct(@PathVariable("id") String id, Model model) {
		log.debug(" Starting of the method editCategory"+product.getDescription());
		product = productDAO.getProductById(id);

		model.addAttribute("product", product);
		log.debug(" End of the method editProduct");
		return "forward:/manage_products";
	}
	@RequestMapping(value = "/manage_products", method = RequestMethod.GET)
	public String listProducts(Model model) {
		log.debug(" Starting of the method listProducts");
		model.addAttribute("product", product);
		model.addAttribute("productList", productDAO.getProduct());
		model.addAttribute("isAdminClickedProducts", "true");
		log.debug(" End of the method listProducts");
		return "/Product";
	}
}


