package com.cakeshop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	 private String product_id;
		private String name;
		private String description;
		private String type;
		private int price;
		
		private String category_id; 
		

		private String supplier_id;
		
		@ManyToOne
		@JoinColumn(name = "category_id", updatable = false, insertable = false, nullable = false)
		private Category category;
		
		@ManyToOne
		@JoinColumn(name = "supplier_id", nullable = false, updatable = false, insertable = false)
		private Supplier supplier;
		
		@Transient
		private MultipartFile image;
		 
		public String getCategory_id() {
			return category_id;
		}

		public void setCategory_id(String category_id) {
			this.category_id = category_id;
		}

		public String getSupplier_id() {
			return supplier_id;
		}

		public void setSupplier_id(String supplier_id) {
			this.supplier_id = supplier_id;
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
		
	
		public String getProduct_id() {
			return product_id;
		}
		public void setProduct_id(String product_id) {
			this.product_id = product_id;
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
