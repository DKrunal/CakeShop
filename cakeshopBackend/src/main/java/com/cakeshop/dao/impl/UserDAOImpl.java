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

import com.cakeshop.dao.UserDAO;
import com.cakeshop.model.User;
@Repository
public class UserDAOImpl implements UserDAO {
	public static Logger log = LoggerFactory.getLogger(UserDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	public UserDAOImpl(){
		
	}

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
 @Transactional
	public List<User> getUsers() {
		String hql = "from User";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		return query.list();
	}
 @Transactional
	public User getUserById(String id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);

	}

 @Transactional
	public User isValid(String id, String password) {
		log.debug("starting of isValid method");
		System.out.println("starting of isValid method");
		String hql = "from User where id ='" + id + "' and password='" + password + "'";
System.out.println(hql);
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("ending of isValid method");
		System.out.println("ending of isValid method");
		return (User) query.uniqueResult();
	}
	@Transactional
	public boolean save(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	@Transactional
	public boolean delete(User user) {
		try {
			sessionFactory.getCurrentSession().delete(user);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	@Transactional
	public boolean update(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
