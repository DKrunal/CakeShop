package com.cakeshop.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cakeshop.dao.CategoryDAO;
import com.cakeshop.model.Category;
import com.cakeshop.model.Supplier;


@Repository
public class CategoryDAOImpl implements CategoryDAO {
	private static Logger log = LoggerFactory.getLogger(CategoryDAOImpl.class);

	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Category> getCategory() {
		String hql = "from Category";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		return query.list();
	}
	@Transactional
	public Category getCategoryById(String id) {
		return (Category) sessionFactory.getCurrentSession().get(Category.class, id);

	}
	@Transactional
	public Category getCategoryByName(String name) {
		String hql = "from Category where name=" + "'"+ name +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return (Category)query.uniqueResult();
	}

	@Transactional
	public boolean save(Category category) {
		try {
			sessionFactory.getCurrentSession().save(category);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	@Transactional
	public boolean saveOrUpdate(Category category) {
		log.debug(" Starting of the method saveOrUpdate");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(category);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Transactional
	public boolean delete(String id) {
		log.debug("Starting of the method : delete ");
		try {
			Category category = new Category();
			category.setCategory_id(id);
			sessionFactory.getCurrentSession().delete(category);
			log.debug("Ending of the method : delete ");
			return true;
		} catch (HibernateException e) {
			log.error("Not able to delete the record:" + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
}
		
