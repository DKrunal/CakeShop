package com.cakeshop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table
@Component
public class Product  implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	 private String id;
		private String name;
		private String description;
		private String type;
		private int price;
		
		private Category category;
		
		private Supplier supplier;
		
		@Transient
		private MultipartFile image;
		 
		public void setCategory_id(String id) {
		//	this.category = category;
		}
		public void setSupplier_id(String id) {
			//	this.category = category;
			}

		public MultipartFile getImage() {
			return image;
		}
		public void setImage(MultipartFile image) {
			this.image = image;
		}
		public Category getCategory() {
			return category;
		}
		public void setCategory(Category category) {
			this.category = category;
		}
		public Supplier getSupplier() {
			return supplier;
		}
		public void setSupplier(Supplier supplier) {
			this.supplier = supplier;
		}
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		
}
