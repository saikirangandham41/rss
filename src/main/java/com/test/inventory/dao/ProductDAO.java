package com.test.inventory.dao;

import java.util.List;

import com.test.inventory.model.Product;

public interface ProductDAO {

	List<Product> save(Product p);
	List<Product> update(Product p);
	List<Product> delete(Product p);
	List<Product> get();
}
