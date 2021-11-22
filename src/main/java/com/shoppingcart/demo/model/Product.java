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

public class Product {

	private String id;
	private String name;
	private Double price;
	private Integer quantity;
	private String thumbnail;
	private String description;

	protected Product() {
	}

	public Product(String id, String name, Double price, String thumbnail, String description, Integer quantity) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.thumbnail = thumbnail;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public String getDescription() {
		return description;
	}

}
