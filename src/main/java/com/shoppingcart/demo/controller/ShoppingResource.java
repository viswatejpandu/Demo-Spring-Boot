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
package com.shoppingcart.demo.controller;

import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.WriteConcernException;
import com.shoppingcart.demo.model.Checkout;
import com.shoppingcart.demo.service.ShoppingService;
/**
 * REST web service for shopping resource.
 *
 * @author hchalla
 */
@RestController
@RequestMapping(value = "/checkout")
public class ShoppingResource {

	public static final String PUCHASE_CONSTANT = "Item";
	final int[] ints = new Random().ints(1, 50).distinct().limit(6).toArray();

	@Autowired
	ShoppingService shoppingService;

	/**
	 * Processes the HTTP POST request to save an instance of
	 * {@code Checkout Details}.
	 *
	 * @param checkout
	 *            the representation of a checkout DB collection in MongoDB
	 */
	@RequestMapping(value = "/addPurchase", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public ResponseEntity<String> save(@Valid @RequestBody Checkout checkout) {
		try {
			String purchaseId = generatePurchaseId();
			// Double totalPrice;
			System.out.println("Checkout Details " + checkout.getTotalPrice());

			checkout.setPurchaseId(purchaseId);
			checkout = shoppingService.saveShoppingCart(checkout);

			return new ResponseEntity<>("{ \"PurchaseId\" : \"" + purchaseId + "\"}", HttpStatus.CREATED);
		} catch (WriteConcernException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrorMessage());
		}

	}

	/**
	 * calculateTotalPrice
	 *
	 * @param productList
	 * @return totalPrice
	 */
	// Below is consideration for Calculate the totalPrice
	/*
	 * if(!checkout.getProductList().isEmpty()) { totalPrice =
	 * calculateTotalPriceFromProductList(checkout.getProductList());
	 * checkout.setTotalPrice(totalPrice);
	 */
	/*
	 * } else { return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
	 * "Empty list of products"); }
	 */
	/*
	 * private Double calculateTotalPriceFromProductList(List<Product>
	 * productList) { return null; }
	 */
	
	
	/**
	 * Processes to genarateRandomId
	 *
	 * @return PurchaseId
	 */
	private String generatePurchaseId() {
		// Generate random id, for example 283952-V8M32
		char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder((100000 + rnd.nextInt(900000)) + "-");
		for (int i = 0; i < 5; i++)
			sb.append(chars[rnd.nextInt(chars.length)]);

		return PUCHASE_CONSTANT + sb.toString();
	}
}
