package com.cakeshop.exceptionHandler;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.hql.internal.ast.QuerySyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ShoppingCartExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(ShoppingCartExceptionHandler.class);
@ExceptionHandler(SQLException.class)
	public ModelAndView handleSQLException(HttpServletRequest request,Exception e){
   log.debug("starting of the method handleSQLException");
    	ModelAndView mv = new ModelAndView("error");
    	mv.addObject("message", "it seems one of the table and fwe fields does not exist in DB" + "see the logger for more information");
    	mv.addObject("errorMessage", e.getMessage());
    	   log.debug("ending of the method handleSQLException");
		return mv;
	}

@ExceptionHandler(CannotCreateTransactionException.class)
public ModelAndView dbServerNotStarted(HttpServletRequest request,Exception e){
log.error("SQLException Occurred: :URL="+request.getRequestURL());
log.error("SQLException Occurred: :Exception="+e.getMessage());
	ModelAndView mv = new ModelAndView("error");
	mv.addObject("message", "it seems DataBase Server Not started" + " see the logger for more information");
	mv.addObject("errorMessage", e.getMessage());
	   log.debug("ending of the method dbServerNotStarted");
	return mv;
}

@ExceptionHandler(QuerySyntaxException.class)
public String handleQuerySyntaxExcption(HttpServletRequest request,Exception e){
log.error("Query Syntax Exception Occurred: :URL="+request.getRequestURL());
log.error("Query Syntax Exception Occurred: :Exception="+e.getMessage());
	ModelAndView mv = new ModelAndView("error");
	mv.addObject("message", "it seems one of the query is not proper" + "see the logger for more information");
	mv.addObject("errorMessage", e.getMessage());
	   log.debug("ending of the method QuerySyntaxException");
	return "database_error";
}

@ExceptionHandler(NoHandlerFoundException.class)
public ModelAndView NoHandlerException(HttpServletRequest request,Exception e){
log.error("NoHandlerException Occurred: :URL="+request.getRequestURL());
log.error("NoHandlerException Occurred: :Exception="+e.getMessage());
	ModelAndView mv = new ModelAndView("error");
	mv.addObject("message", "it seems NoHandlerException" + "see the logger for more information");
	mv.addObject("errorMessage", e.getMessage());
	   log.debug("ending of the method NoHandlerException");
	return mv;
}
@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="IOException occured")
@ExceptionHandler(IOException.class)
public ModelAndView handleIOException(HttpServletRequest request,Exception e){
log.error("IOException Occurred: :URL="+request.getRequestURL());
log.error("IOException Occurred: :Exception="+e.getMessage());
	ModelAndView mv = new ModelAndView("error");
	mv.addObject("message", "it seems IOException" + "see the logger for more information");
	mv.addObject("errorMessage", e.getMessage());
	   log.debug("ending of the method IOException");
	return mv;
}
}

