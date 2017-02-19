package com.cakeshop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Cart implements Serializable{

	private static final long serialVersionUID = -8955103200258023974L;
	 
		@Id
	 	@GeneratedValue
	    private int cartId;
		
		private String product_id;
		
		private String product_name;
		
		private int price;
		
		private int quantity;
		
		private String status;
		
		private String mail_id;

		public int getCartId() {
			return cartId;
		}

		public void setCartId(int cartId) {
			this.cartId = cartId;
		}

		public String getProduct_id() {
			return product_id;
		}

		public void setProduct_id(String product_id) {
			this.product_id = product_id;
		}

		public String getProduct_name() {
			return product_name;
		}

		public void setProduct_name(String product_name) {
			this.product_name = product_name;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getMail_id() {
			return mail_id;
		}

		public void setMail_id(String mail_id) {
			this.mail_id = mail_id;
		}

		
	    
	    
		
	
	
	
}
