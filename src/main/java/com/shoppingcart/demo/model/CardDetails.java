/*
 * $Id$
 *
 * Copyright (C). All Right Reserved.
 *
 * Copyright in the whole or any part of this document belongs to Harish
 *  and it must be kept strictly confidential by the recipient and
 * must not be used, sold, licensed, transferred, copied or reproduced in
 * whole or in any part in any manner or form or on any media to any person
 * without the prior written consent of Harish.
 */
package com.shoppingcart.demo.model;
/**
 * Credit card details.
 *
 * @author hchalla
 */
public class CardDetails {
	private String cardNumber;
	private ExpiryDate expiryDate;
	private String cvv;
	

	protected CardDetails(){}

    public CardDetails(String cardNumber, ExpiryDate expiryDate,String cvv) {
    	this.cardNumber = cardNumber;
    	this.expiryDate = expiryDate;
    	this.cvv = cvv;
    }
    
	public String getCardNumber() {
		return cardNumber;
	}
	
	public ExpiryDate getExpiryDate() {
		return expiryDate;
	}

	public String getCvv() {
		return cvv;
	}
}
