package com.cakeshop.model;

import java.io.Serializable;

public class CardDetail implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int cardNumber;
	private String cardExpMonth;
	private String cardExpYear;
	private int cardCVV;
	private String cardName;
	
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardExpMonth() {
		return cardExpMonth;
	}
	public void setCardExpMonth(String cardExpMonth) {
		this.cardExpMonth = cardExpMonth;
	}
	public String getCardExpYear() {
		return cardExpYear;
	}
	public void setCardExpYear(String cardExpYear) {
		this.cardExpYear = cardExpYear;
	}
	public int getCardCVV() {
		return cardCVV;
	}
	public void setCardCVV(int cardCVV) {
		this.cardCVV = cardCVV;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	
	
	
	
}
