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
package com.shoppingcart.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.demo.model.Checkout;
import com.shoppingcart.demo.repository.CheckoutRepository;

@Service
public class ShoppingServiceImpl implements ShoppingService {
	
	@Autowired
	private CheckoutRepository checkoutRepository;
	
	@Override
	public Checkout saveShoppingCart(Checkout checkout) {
		return checkoutRepository.save(checkout);
	}

}
