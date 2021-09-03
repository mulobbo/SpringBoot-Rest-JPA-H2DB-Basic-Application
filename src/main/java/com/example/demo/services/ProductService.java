package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired ProductRepository productRepository;
	
	public List<Product>  getAllProduct() {
		List<Product> allProducts = new ArrayList<Product>();
		allProducts=(List<Product>) productRepository.findAll();
		if (allProducts.size()>0) {
			return allProducts;
		}else {
			return new ArrayList<Product>();
		}
		}
	
	public void createProduct(Product product) {
			productRepository.save(product);		
	}
	
	public void deleteProductById(Product product) {
		productRepository.deleteById(product.getId());
	}
	
	public void updateProductById(Product product) {
		
		Optional<Product> updatableProduct = productRepository.findById(product.getId());
		if (updatableProduct.isPresent()) {
			Product newProduct = new Product();
			newProduct = updatableProduct.get();
			newProduct.setName(product.getName());
			newProduct.setActive(product.isActive());
			newProduct.setCategory(product.getCategory());
			newProduct.setDescription(product.getDescription());
			newProduct.setStock(product.getStock());
			
			productRepository.save(newProduct);
		}
		
		
		
		
	}
	
	
	public Product getProductById (Integer id) {
		
		Optional<Product> result =productRepository.findById(id);
		if (result.isPresent()) {
			return result.get();
		}
		return null;
	}
	
	
	
}
