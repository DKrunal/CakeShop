package com.cakeshop.dao;

import com.cakeshop.model.Billing;

public interface BillingDAO {
	public boolean addBilling(Billing billing);

	public Billing getBilling(String mail_id);

	public String generateID();
}
