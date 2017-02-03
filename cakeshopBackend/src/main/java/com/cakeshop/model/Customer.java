package com.cakeshop.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;

public class Customer implements Serializable {

	private static final long serialVersionUID = 3946022393959317360L;

		@Id
	    @GeneratedValue
	    private int customerId;
		
		@NotEmpty
	    private String customerName;
		
	    @NotEmpty 
	    private String customerPhone;
	    
	    private String customerEmail;
	    
	    @NotEmpty 
	    private String username;
	    
	    @NotEmpty 
	    private String password;
	    
	    private boolean enabled;
	    
	    @OneToOne
	    private BillingAdd billingAdd;

	    @OneToOne
	    private ShippingAdd shippingAdd;
	    
	    @OneToOne
	    private Cart cart;

		public int getCustomerId() {
			return customerId;
		}

		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}

		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}

		public String getCustomerPhone() {
			return customerPhone;
		}

		public void setCustomerPhone(String customerPhone) {
			this.customerPhone = customerPhone;
		}

		public String getCustomerEmail() {
			return customerEmail;
		}

		public void setCustomerEmail(String customerEmail) {
			this.customerEmail = customerEmail;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public boolean isEnabled() {
			return enabled;
		}

		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}

		public BillingAdd getBillingAdd() {
			return billingAdd;
		}

		public void setBillingAdd(BillingAdd billingAdd) {
			this.billingAdd = billingAdd;
		}

		public ShippingAdd getShippingAdd() {
			return shippingAdd;
		}

		public void setShippingAdd(ShippingAdd shippingAdd) {
			this.shippingAdd = shippingAdd;
		}

		public Cart getCart() {
			return cart;
		}

		public void setCart(Cart cart) {
			this.cart = cart;
		}
	    
}