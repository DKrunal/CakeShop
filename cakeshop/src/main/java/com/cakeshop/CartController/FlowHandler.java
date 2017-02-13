package com.cakeshop.CartController;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cakeshop.model.BillingAddress;
import com.cakeshop.model.CardDetail;
import com.cakeshop.model.Order;
import com.cakeshop.model.ShippingAddress;

@Component
public class FlowHandler {
	
	private static Logger log = LoggerFactory.getLogger(FlowHandler.class);
	
	@Autowired
	Order order;
	
	public Order initFlow(){
		log.debug("WebFLow mehtod --> initFlow");
		return order;
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
		log.debug("WebFLow mehtod --> addCardDetail");
		order.setCardDetail(cardDetail);
		return "success";	
	}*/
	
	}
