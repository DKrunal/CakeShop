package com.cakeshop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table
@Component
public class ShippingAddress implements Serializable {

	private static final long serialVersionUID = -4827702005129017884L;

	
	@Id
    @GeneratedValue
    private int shippingAddressId;
	
	private String Line1;
	 
	 private String Line2;
	 
	 private String city;
	 
    private String state;
    
    private String zipCode;
    
    private String country;
    
    @OneToOne
    private Customer customer;

	public int getShippingAddId() {
		return shippingAddressId;
	}

	public void setShippingAddId(int shippingAddId) {
		this.shippingAddressId = shippingAddId;
	}

	public String getLine1() {
		return Line1;
	}

	public void setLine1(String line1) {
		Line1 = line1;
	}

	public String getLine2() {
		return Line2;
	}

	public void setLine2(String line2) {
		Line2 = line2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
    
    
}
