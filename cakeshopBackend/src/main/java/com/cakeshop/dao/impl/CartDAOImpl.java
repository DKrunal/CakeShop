package com.cakeshop.dao.impl;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cakeshop.dao.CartDAO;
import com.cakeshop.model.Cart;

@Repository
public class CartDAOImpl implements CartDAO {
	
	private static Logger log = LoggerFactory.getLogger("CartDAOImpl.class");
	
	@Autowired
	private SessionFactory sessionfactory;
	
	public CartDAOImpl(SessionFactory sessionfactory) 
	{
		this.sessionfactory = sessionfactory;
	}
	
	@Transactional
	public void addCart(Cart cart) {
		
		log.info("Add to Cart");
		sessionfactory.getCurrentSession().saveOrUpdate(cart);	
	}

	@Transactional
	public void deleteCart(int cartId) {
		
		log.info("Delete Cart Initiated.");
		Cart cart = new Cart();
		cart.setCartId(cartId);
		sessionfactory.getCurrentSession().delete(cart);
		
	}
	
	@SuppressWarnings({ "unchecked" })
	@Transactional
	public Cart getCart(String product_id) {
		log.info("Get Cart by User ID "+product_id);
		String hql = "from Cart where mail_id=" + "'" + product_id + "'";
		Query query = sessionfactory.getCurrentSession().createQuery(hql);
		List<Cart> list = (List<Cart>) query.list();
		if (list != null && !list.isEmpty()) 
		{
			return list.get(0);
		}
		return null;
	}

	@Transactional
	public List<Cart> list() {
		log.info("List Full Cart");
		@SuppressWarnings("unchecked")
		List<Cart> list = (List<Cart>) sessionfactory.getCurrentSession().createCriteria(Cart.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return list;
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Cart> userCartList(String username) {
		log.info("get Cart by User ID "+username);
		String hql = "from Cart where mail_id=" + "'" + username + "'";
		Query query = sessionfactory.getCurrentSession().createQuery(hql);
		List<Cart> list = query.list();
		if (list != null && !list.isEmpty()) 
		{
			return list;
		}
		return null;
	}
	@SuppressWarnings({ "unchecked" })
	@Transactional
	public Cart getByIdCart(int id) {
		log.info("Get Cart by ID "+id);
		String hql = "from Cart where cartid = "+id;
		Query query = sessionfactory.getCurrentSession().createQuery(hql);
		List<Cart> list = (List<Cart>) query.list();
		if (list != null && !list.isEmpty()) 
		{
			return list.get(0);
		}
		return null;
	}

	@Transactional
	public void deleteAllCartItem(String mail_id) {
		log.info("starting of delete cart" + mail_id );
		
		String hql = "delete from Cart where mail_id=:mailid";
		Query query= sessionfactory.getCurrentSession().createQuery(hql);
		query.setParameter("mailid", mail_id);
		query.executeUpdate();
		log.info("Ending of delete cart" + mail_id +""+hql);
		
	}

}
