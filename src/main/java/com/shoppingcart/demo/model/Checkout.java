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

import java.util.List;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

/**
 * CheckoutDetails documents.
 *
 * @author hchalla
 */
@Document(collection = "CheckoutDetails")
public class Checkout {

	@Id
	private String id;
	
	@Indexed(direction = IndexDirection.ASCENDING)
	@DecimalMax(value = "100000")
	@DecimalMin(value = "10")
	@NotNull
	private Double totalPrice;
	private String purchaseId;
	private UserDetails userDetails;
	private CardDetails cardDetails;
	private List<Product> productList;
	
	protected Checkout(){}

	public Checkout(Double totalPrice, UserDetails userDetails, CardDetails cardDetails, List<Product> productList) {
		this.totalPrice = totalPrice;
		this.userDetails = userDetails;
		this.cardDetails = cardDetails;
		this.productList = productList;
	}

	public String getId() {
		return id;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public String getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(String purchaseId) {
		this.purchaseId = purchaseId;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public CardDetails getCardDetails() {
		return cardDetails;
	}

	public List<Product> getProductList() {
		return productList;
	}

	
}
