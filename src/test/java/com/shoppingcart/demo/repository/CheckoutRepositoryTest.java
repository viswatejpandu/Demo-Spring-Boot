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
package com.shoppingcart.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shoppingcart.demo.model.Address;
import com.shoppingcart.demo.model.CardDetails;
import com.shoppingcart.demo.model.Checkout;
import com.shoppingcart.demo.model.ExpiryDate;
import com.shoppingcart.demo.model.Product;
import com.shoppingcart.demo.model.UserDetails;

@ContextConfiguration(classes = {MongoConfigTest.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CheckoutRepositoryTest {

	  @Autowired
	  private CheckoutRepository checkoutRepository;


	  @Test
	  public void testSaveEvent() {
		  checkoutRepository.save(buildCheckout());
	  }

	  private Checkout buildCheckout() {
		Address address = new Address("street","street no","city","state","zipCode");
		UserDetails  userDetails = new UserDetails("test","user", address);
		ExpiryDate expiryDate= new ExpiryDate(02,02);
		List<Product> productList = new ArrayList<Product>();
		Product product = new Product("id","name", 30.00, "phone","model",2);
		productList.add(product);
		CardDetails cardDetails = new CardDetails("xxxxxx",expiryDate,"xxx");
		Checkout result = new Checkout(100.00, userDetails, cardDetails, productList);

	    return result;
	  }
}
