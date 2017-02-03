package com.cakeshop.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


public class Cart implements Serializable{

	private static final long serialVersionUID = -8955103200258023974L;
	 
		@Id
	 	@GeneratedValue
	    private int cartId;
		
		@OneToMany
		private List<CartItem> cartItems;
		
		@OneToOne
		private Customer customer;
		
	    private double grandTotal;

		public int getCartId() {
			return cartId;
		}

		public void setCartId(int cartId) {
			this.cartId = cartId;
		}

		public List<CartItem> getCartItems() {
			return cartItems;
		}

		public void setCartItems(List<CartItem> cartItems) {
			this.cartItems = cartItems;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		public double getGrandTotal() {
			return grandTotal;
		}

		public void setGrandTotal(double grandTotal) {
			this.grandTotal = grandTotal;
		}
	    
	    
		
	
	
	
}
