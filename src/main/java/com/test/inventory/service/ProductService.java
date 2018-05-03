package com.test.inventory.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.inventory.dao.ProductDAOImpl;
import com.test.inventory.model.Product;

@Service
public class ProductService {
	
	@Autowired ProductDAOImpl productDAO;
	private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

	
	public List<Product> addProduct(Product p) {
		logger.info("Add Product", p);
		return productDAO.save(p);
	}
	
	public List<Product> editProduct(Product p) {
		logger.info("Edit Product", p);
		return productDAO.update(p);
	}
	
	public List<Product> deleteProduct(Product p) {
		logger.info("Delete Product", p);
		return productDAO.delete(p);
	}
	
}
