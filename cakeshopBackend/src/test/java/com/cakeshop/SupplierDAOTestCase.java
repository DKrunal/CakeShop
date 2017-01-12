package com.cakeshop;


import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.cakeshop.dao.SupplierDAO;
import com.cakeshop.model.Supplier;

public class SupplierDAOTestCase {
	@Autowired
	static SupplierDAO supplierDAO;

	@Autowired
	static Supplier supplier;

	@Autowired
	static AnnotationConfigApplicationContext config;

	@BeforeClass
	public static void init(){
		config = new  AnnotationConfigApplicationContext();
		config.scan("com.cakeshop");
		config.refresh();

		supplier = (Supplier) config.getBean("supplier");
		supplierDAO = (SupplierDAO) config.getBean("supplierDAOImpl");
	}

}
