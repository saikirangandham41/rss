package com.test.inventory.dao;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.test.inventory.model.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	private static final Logger logger = LoggerFactory.getLogger(ProductDAOImpl.class);
	@Override
	public List<Product> save(Product p) {
		logger.info("Add Product " , p);
		return get();
	}

	@Override
	public List<Product> update(Product p) {
		logger.info("Update Product", p);
		return get();
	}

	@Override
	public List<Product> delete(Product p) {
		logger.info("Delete Product", p);
		return get();
	}

	@Override
	public List<Product> get() {
		// TODO Auto-generated method stub
		return new ArrayList<Product>();
	}
	

}
