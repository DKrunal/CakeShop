package com.cakeshop.dao;

import com.cakeshop.model.Payment;

public interface PaymentDAO {
	public boolean addPaymentInfo(Payment payment);

	public Payment getPaymentInfo(String mail_id);
}
