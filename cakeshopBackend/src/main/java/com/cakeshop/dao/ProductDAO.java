package com.cakeshop.dao;

import java.util.List;

import com.cakeshop.model.Product;


public interface ProductDAO {
	public List<Product> getProduct();
	public Product getProductById(String id);
	public boolean save(Product product);
	public boolean update(Product product);
	public boolean delete(String id);
	public boolean saveOrUpdate(Product product);
	public Product getProductByName(String name);

}
