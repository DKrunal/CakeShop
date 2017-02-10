package com.cakeshop.dao.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cakeshop.dao.BillingDAO;
import com.cakeshop.model.Billing;


@Repository
public class BillingDAOImpl implements BillingDAO {
	
	private static final Logger log = LoggerFactory.getLogger(PaymentDAOImpl.class);
	@Autowired
	SessionFactory sessionFactory;
	
	public BillingDAOImpl(SessionFactory sessionFactory)
	{
		try 
		{
			this.sessionFactory = sessionFactory;
			log.info("Connection is successfully established");
		}
		catch (Exception e) 
		{
			log.error("Unable to establish H2 connection, check Application Context file");
			e.printStackTrace();
		}
	}

	@Transactional
	public boolean addBilling(Billing billing) {
		log.debug("Add PaymentInfo method initiated");
		try 
		{
			sessionFactory.getCurrentSession().saveOrUpdate(billing);
			log.debug("Add PaymentInfo method success");
		}
		catch (HibernateException e) 
		{	
			e.printStackTrace();
			log.error("Add PaymentInfo method error");
			return false;
		}
		return true;
	}

	@Transactional
	public Billing getBilling(String mail_id) {
		log.debug("Get PaymentInfo method initiated");
		try 
		{
			log.debug("Get PaymentInfo method success");
			return (Billing) sessionFactory.getCurrentSession().get(Billing.class, mail_id);
		}
		catch (HibernateException e) 
		{
			e.printStackTrace();
			log.debug("Get PaymentInfo method error");
			return null;
		}
	}

	@Transactional
	public String generateID() {
		log.info("Generating random Session ID");
		String uuid;
		uuid = UUID.randomUUID().toString();
		@SuppressWarnings("unused")
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy_MM_dd");
		String localDate = LocalDate.now().toString();
		String bill_no = "CartMHG-"+localDate+uuid;
		return bill_no;
	}
	}

