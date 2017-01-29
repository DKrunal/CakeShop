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

import com.cakeshop.dao.ProductDAO;
import com.cakeshop.model.Category;
import com.cakeshop.model.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {
	private static Logger log = LoggerFactory.getLogger(ProductDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Product> getProduct() {
		log.debug("starting of method getProduct ");
		String hql = "from Product";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("ending of method getProduct ");

		return query.list();
	}
	@Transactional
	public Product getProductById(String id) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, id);

	}

	@Transactional
	public boolean save(Product product) {
		try {
			sessionFactory.getCurrentSession().save(product);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	@Transactional
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
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
			Product product = new Product();
			product.setProduct_id(id);
			sessionFactory.getCurrentSession().delete(product);
			log.debug("Ending of the method : delete ");
			return true;
		} catch (HibernateException e) {
			log.error("Not able to delete the record:" + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public boolean saveOrUpdate(Product product) {
			log.debug(" Starting of the method saveOrUpdate");
			try {
				sessionFactory.getCurrentSession().saveOrUpdate(product);
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
			return true;
		}
	
	@Override
	public Product getProductByName(String name) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, name);

	}

}
