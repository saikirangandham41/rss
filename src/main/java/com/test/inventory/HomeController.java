package com.test.inventory;

import java.util.*;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.inventory.crud.ProductCRUDRespository;
import com.test.inventory.model.Login;
import com.test.inventory.model.Product;

@Controller
public class HomeController {

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
	public String toOpenWelcomePage(@Valid @ModelAttribute("login") Login login, BindingResult bindingResult,
			Model model) {
		logger.info("loginFormSubmit", login);
		if (bindingResult.hasErrors()) {
			logger.error("Please check your credentials ");
			return "home";
		}
		if (login.getUsername().equals("test")) {
			logger.info("login", "Success");
			model.addAttribute("username", "test");
			return "welcome";
		}

		else {
			model.addAttribute("loginFormError", "Username and Password Don't match");
			return "home";
		}
	}

	@RequestMapping(value = "/addProductForm", method = RequestMethod.POST)
	public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult,
			Model model) {
		logger.info("addProductForm", product.getItemId());
		ProductCRUDRespository repo = new ProductCRUDRespository();
		repo.insert_values(product.getItemId(), product.getName(), product.getQuantity(), product.getDescription());
		this.products.clear();
		this.products = repo.get_values();
		model.addAttribute("products", this.products);
		return "welcome";
	}

	@RequestMapping(value = "/editProduct/{itemId}", method = RequestMethod.GET)
	public String edit(@PathVariable String itemId, Model model) {
		logger.info("editProduct", itemId);
		ProductCRUDRespository repo = new ProductCRUDRespository();
		Product p = repo.get_value_of_product(itemId);
		model.addAttribute("itemId", itemId);
		model.addAttribute("name", p.getName());
		model.addAttribute("description", p.getDescription());
		model.addAttribute("qty", p.getQuantity());
		return "editProduct";
	}

	@RequestMapping(value = "/deleteProduct/{itemId}", method = RequestMethod.GET)
	public String delete(@PathVariable String itemId, Model model) {
		logger.info("deleteProduct", itemId);
		ProductCRUDRespository repo = new ProductCRUDRespository();
		Product p = repo.get_value_of_product(itemId);
		model.addAttribute("itemID", itemId);
		model.addAttribute("name", p.getName());
		model.addAttribute("description", p.getDescription());
		model.addAttribute("qty", p.getQuantity());
		return "deleteProduct";
	}

	@RequestMapping(value = "/editProduct/editProductForm", method = RequestMethod.GET)
	public String updateProduct(@RequestParam(value = "itemId") String itemId,
			@RequestParam(value = "quantity") int quantity, @RequestParam(value = "name") String name,
			@RequestParam(value = "description") String description, Model model) {
		logger.info("editProductForm", itemId);

		ProductCRUDRespository repo = new ProductCRUDRespository();
		repo.edit_values(new Product(itemId, name, quantity, description));
		this.products.clear();
		this.products = repo.get_values();
		model.addAttribute("products", this.products);
		return "welcome";
	}

	@RequestMapping(value = "/deleteProduct/deleteProductForm", method = RequestMethod.GET)
	public String removeProduct(@RequestParam(value = "itemId") String itemId,
			@RequestParam(value = "quantity") int quantity, @RequestParam(value = "name") String name,
			@RequestParam(value = "description") String description, Model model) {
		logger.info("deleteProductForm", itemId);
		ProductCRUDRespository repo = new ProductCRUDRespository();
		repo.delete_value(new Product(itemId, name, quantity, description));
		this.products.clear();
		this.products = repo.get_values();
		model.addAttribute("products", this.products);
		return "welcome";
	}

}
