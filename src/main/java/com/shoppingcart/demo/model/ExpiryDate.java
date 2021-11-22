/*
 * $Id$
 *
 * Copyright (C). All Right Reserved.
 *
 * Copyright in the whole or any part of this document belongs to Harish
 * Limited and it must be kept strictly confidential by the recipient and
 * must not be used, sold, licensed, transferred, copied or reproduced in
 * whole or in any part in any manner or form or on any media to any person
 * without the prior written consent of Harish.
 */
package com.shoppingcart.demo.model;

public class ExpiryDate {
	
	private Integer year;
	private Integer month;
	
	protected ExpiryDate(){}

    public ExpiryDate(Integer year, Integer month) {
    	this.year = year;
    	this.month = month;
    }
    
	public Integer getYear() {
		return year;
	}
	
	public Integer getMonth() {
		return month;
	}
}
