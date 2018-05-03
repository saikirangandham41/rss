package com.test.inventory;


import java.util.*;

import javax.validation.Valid;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.inventory.model.Login;
import com.test.inventory.model.Product;
import com.test.inventory.service.ProductService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired ProductService productService;
	
	List<Product> products = new ArrayList<Product>();
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)		
	public String home1() {
		return "home"; 
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)		
	public String home2() {
		return "home"; 
	}
	
	@RequestMapping(value = "/loginFormSubmit", method = RequestMethod.POST)
	public String toOpenWelcomePage( @Valid @ModelAttribute("login") Login login, BindingResult bindingResult, Model model) {
		logger.info("loginFormSubmit", login);
		if (bindingResult.hasErrors()) {
			logger.error("Please check your credentials ");
			return "home";
		}
		if(login.getUsername().equals("test")) 	{	
			// &&login.getPassword().equals("test")
			logger.info("login", "Success");
			model.addAttribute("username", "test");
			return "welcome";}
		
		else {
			model.addAttribute("loginFormError", "Username and Password Don't match");
		return "home";
		}
	}
	
	@RequestMapping(value = "/addProductForm", method = RequestMethod.POST)
	public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, Model model) {
		logger.info("addProductForm", product);
		this.products.add(product);
		this.productService.addProduct(product);
		model.addAttribute("products", this.products);
		return "welcome";
	}
	
	@RequestMapping(value = "/editProductForm", method = RequestMethod.POST)
	public String editProduct(Product p) {
		/** Implementation comes here*/
		return "welcome";
	}
	
	@RequestMapping(value = "/deleteProductForm", method = RequestMethod.POST)
	public String deleteProduct(Product p) {
		/** Implementation comes here*/
		return "welcome";
	}
	
}
