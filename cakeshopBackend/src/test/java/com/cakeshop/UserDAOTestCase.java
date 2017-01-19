package com.cakeshop;

import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cakeshop.dao.UserDAO;
import com.cakeshop.model.User;

public class UserDAOTestCase {

	//Autowire - DAO, DO, context
	
	
	@Autowired
	static UserDAO userDAO;
	
	@Autowired
	static User  user;
	
	@Autowired
	static AnnotationConfigApplicationContext context;
	
	
	//Previously we written constructor
	//But in Junit we need to write a method
	//this method should call automatically when JUnit Test case run
	@BeforeClass   //we can write @BeforeClasses only for the static methods
	public static void init()
	{
		context = new  AnnotationConfigApplicationContext();
		context.scan("com.cakeshop");
		context.refresh();
		
		user = (User) context.getBean("user");
		
		userDAO = (UserDAO) context.getBean("userDAOImpl");
		 
	}	
	
/*	@Test
	public void getUserTestCase()
	{
		
		user = userDAO.getUserById("kd");
		
		
		//Assert statements
	  Assert.assertNotNull("getUserTestCase", user);
		
	}*/
	
	
	/*@Test
	public void validateCredentials()
	{
	user=	userDAO.isValid("niit", "niit");
	 Assert.assertNotNull("validateCredentials", user);
	}
	*/
	
	/*@Test
	public void inValidateCredentials()
	{
	user=	userDAO.isValid("Vibhav", "Vibhav");
	 Assert.assertNull("inValidateCredentials", user);
	 
	 //OR
	// Assert.assertEquals("inValidateCredentials", null , user );
	 
	}
	*/
	
	
	/*@Test
	public void getAllUsersTestCase()
	{
	 int size=	userDAO.getUsers().size();
	 Assert.assertEquals(" length check ", 8 , size);
	 
	 
	}*/
	
	/*@Test
	public void demoTestCase()
	{
		
	System.out.println("in demo TestCase");
	}*/
	/*@Test
	public void saveTestCase()
	{
		
		//you have create /insert new row in db
		//provide values for user
		
		user.setId("kd");
		user.setFname("krunal");
		user.setNumber("989898989");
		user.setPassword("12345");
		user.setRole("ROLE_ADMIN");
		
		
	 Assert.assertEquals("saveTestCase", true, 	userDAO.save(user));
		
	}*/
	
	
/*	@Test
	public void updateTestCase()
	{
		user = userDAO.getUserById("kd");
		
		user.setRole("ROLE_ADMIN");
		
	 Assert.assertEquals("updateTestCase", true, userDAO.update(user));
		
	}*/
	/*@Test
	public void deleteTestCase()
	{
		user = userDAO.getUserById("krunal");
		Assert.assertEquals("deleteTestCase",true, userDAO.delete(user));
	}*/
		

}
