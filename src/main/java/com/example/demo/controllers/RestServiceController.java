package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Product;
import com.example.demo.services.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping(value="/api")
public class RestServiceController {

	@Autowired
	ProductService productService;

	@GetMapping(value = { "/", "getAll" })
	public List<Product> getAllProducts() {
		return productService.getAllProduct();
	}

	@PostMapping(value = "/add")
	public void addProduct(@RequestBody Product product) {
		productService.createProduct(product);
	}

	@PostMapping(value = "/update")
	public void updateProduct(@RequestBody Product product) {
		productService.updateProductById(product);
	}

	@PostMapping(value = "/delete")
	public void deleteProduct(@RequestBody Product product) {
		productService.deleteProductById(product);
	}

	@GetMapping("/products/{id}")
	public Product getById(@PathVariable Integer id) {
		return productService.getProductById(id);
	}

}
