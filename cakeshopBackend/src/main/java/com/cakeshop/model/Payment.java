package com.cakeshop.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Payment {
	@Id
	private String mail_id;
	
	private String f_name;
	
	private String l_name;
	
	private String st_line1;
	
	private String st_line2;
	
	private String city;
	
	private String state;
	
	private int zip_code;
	
	private String mobile;
	
	private String method;

	public String getMail_id() {
		return mail_id;
	}

	public void setMail_id(String mail_id) {
		this.mail_id = mail_id;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public String getSt_line1() {
		return st_line1;
	}

	public void setSt_line1(String st_line1) {
		this.st_line1 = st_line1;
	}

	public String getSt_line2() {
		return st_line2;
	}

	public void setSt_line2(String st_line2) {
		this.st_line2 = st_line2;
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

	public int getZip_code() {
		return zip_code;
	}

	public void setZip_code(int zip_code) {
		this.zip_code = zip_code;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	
	
}
