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

import com.cakeshop.dao.SupplierDAO;
import com.cakeshop.model.Category;
import com.cakeshop.model.Supplier;

@Repository
public class SupplierDAOImpl implements SupplierDAO {
	private static Logger log = LoggerFactory.getLogger(SupplierDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Supplier> getSuppliers() {
		String hql = "from Supplier";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		return query.list();
	}
	@Transactional
	public Supplier getSupplierById(String id) {
		return (Supplier) sessionFactory.getCurrentSession().get(Supplier.class, id);

	}
/*	@Transactional
	public Supplier isValid(String id, String password) {
		String hql = "from Supplier where id ='" + id + "'  and password='" + password + "'";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		return (Supplier) query.uniqueResult();
	}*/
	@Transactional
	public boolean save(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().save(supplier);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	@Transactional
	public boolean update(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().update(supplier);
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
			Supplier supplier = new Supplier();
			supplier.setSupplier_id(id);
			sessionFactory.getCurrentSession().delete(supplier);
			log.debug("Ending of the method : delete ");
			return true;
		} catch (HibernateException e) {
			log.error("Not able to delete the record:" + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public boolean saveOrUpdate(Supplier supplier) {
	
			log.debug(" Starting of the method saveOrUpdate");
			try {
				sessionFactory.getCurrentSession().saveOrUpdate(supplier);
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
			return true;
		}
	@Transactional
	public Supplier getSupplierByName(String name) {
		String hql = "from Supplier where name=" + "'"+ name +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return (Supplier)query.uniqueResult();
	}
	


}
