package com.test.inventory.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Product {

	@NotEmpty
	@NotNull
	private String itemId;

	@NotEmpty
	@NotNull
	private String name;

	private int quantity;

	private String description;

	public Product() {
	}

	public Product(String itemId, String name, int quantity, String description) {
		this.itemId = itemId;
		this.name = name;
		this.quantity = quantity;
		this.description = description;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
