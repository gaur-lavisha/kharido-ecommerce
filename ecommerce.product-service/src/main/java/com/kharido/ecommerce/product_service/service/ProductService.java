package com.kharido.ecommerce.product_service.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.kharido.ecommerce.product_service.entity.Product;
import com.kharido.ecommerce.product_service.repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository repo;

	public ProductService(ProductRepository repo) {
		this.repo = repo;
	}

	public Product save(Product p) {
		return repo.save(p);
	}

//	public Product get(Long id) {
//		return repo.findById(id).orElseThrow();
//	}
	public Product get(Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
	}

	public List<Product> all() {
		return repo.findAll();
	}

}
