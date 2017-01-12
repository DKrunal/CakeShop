package com.cakeshop.dao;

import java.util.List;

import com.cakeshop.model.Category;


public interface CategoryDAO {
	public List<Category> getCategory();
	public Category getCategoryById(String id);
	public boolean save(Category category);
	public boolean update(Category category);
	public boolean delete(String id);
}
