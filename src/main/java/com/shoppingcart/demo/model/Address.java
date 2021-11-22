/*
 * $Id$
 *
 * Copyright (C). All Right Reserved.
 *
 * Copyright in the whole or any part of this document belongs to Harish
 * and it must be kept strictly confidential by the recipient and
 * must not be used, sold, licensed, transferred, copied or reproduced in
 * whole or in any part in any manner or form or on any media to any person
 * without the prior written consent of Harish.
 */
package com.shoppingcart.demo.model;
/**
 * Address of the user.
 *
 * @author hchalla
 */
public class Address {
	
	private String street;
	private String streetExtension;
	private String city;
	private String state;
	private String zipCode;
	
	 protected Address(){}

	    public Address(String street, String streetExtension,String city, String state,String zipCode) {
	    	this.street = street;
	    	this.streetExtension = streetExtension;
	    	this.city = city;
	        this.state = state;
	        this.zipCode = zipCode;
	    }
	    public String getStreet() {
			return street;
		}

		public String getStreetExtension() {
			return streetExtension;
		}
		
		public String getCity() {
	        return city;
	    }
		
		public String getState() {
			return state;
		}	

		public String getZipCode() {
			return zipCode;
		}
	    
}
