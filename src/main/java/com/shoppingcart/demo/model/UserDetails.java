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

public class UserDetails {

	String firstName;
	String lastName;
	Address address;
	
	protected UserDetails(){}

    public UserDetails(String firstName, String lastName,Address address) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.address = address;
        
    }
    
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Address getAddress() {
		return address;
	}
}
