package com.cakeshop;


import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.cakeshop.dao.CategoryDAO;
import com.cakeshop.model.Category;

public class CategoryDAOTestCase {

	@Autowired
	static CategoryDAO categoryDAO;

	@Autowired
	static Category category;

	@Autowired
	static AnnotationConfigApplicationContext config;

	@BeforeClass
	public static void init(){
		config = new  AnnotationConfigApplicationContext();
		config.scan("com.cakeshop");
		config.refresh();

		category = (Category) config.getBean("category");
		categoryDAO = (CategoryDAO) config.getBean("CategoryDAOImpl");
	}

}
