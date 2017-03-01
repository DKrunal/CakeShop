package com.cakeshop.CartController;



import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cakeshop.dao.CartDAO;
import com.cakeshop.model.BillingAddress;
import com.cakeshop.model.Cart;
import com.cakeshop.model.Order;
import com.cakeshop.model.ShippingAddress;

@Component
public class FlowHandler {
	
	private static Logger log = LoggerFactory.getLogger(FlowHandler.class);
	
	@Autowired
	Order order;
	
	@Autowired
	Cart cart;
	
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	HttpSession session;
	
	public Order initFlow(){
		log.debug("WebFLow mehtod --> initFlow");
		return order;
	}
	public Cart initCart(){
		log.debug("WebFLow mehtod --> initCart");
		return cart;
	}
	
	public String addShippingAddress(Order order, ShippingAddress shippingAddress){
		log.debug("WebFLow mehtod --> addShippingAddress");
		order.setShippingAddress(shippingAddress);
		return "success";	
	}
	
	public String addBillingAddress(Order order, BillingAddress billingAddress){
		log.debug("WebFLow mehtod --> addBillingAddress");
		order.setBillingAddress(billingAddress);
		return "success";	
	}
	
	/*public String addCardDetail(Order order, CardDetail cardDetail){
		log.debug("WebFLow method --> addCardDetail");
		order.setCardDetail(cardDetail);
		return "success";	
	}*/
	
	public void deleteAllCartItem(Cart cart,Principal principal,HttpSession session) {
		log.debug("strting of method " );
		cart.setMail_id(principal.getName());
		cartDAO.deleteAllCartItem(cart.getMail_id());
		log.debug("ending of method deleteAllCartItem"+ cart.getMail_id() );
	}
	

	}
