package com.cakeshop;



import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cakeshop.dao.ProductDAO;
import com.cakeshop.model.Product;

public class ProductDAOTestCase {
	@Autowired
	static ProductDAO productDAO;

	@Autowired
	static Product product;

	@Autowired
	static AnnotationConfigApplicationContext config;

	@BeforeClass
	public static void init(){
		config = new  AnnotationConfigApplicationContext();
		config.scan("com.cakeshop");
		config.refresh();

		product = (Product) config.getBean("product");
		productDAO = (ProductDAO) config.getBean("productDAOImpl");
	}

}
