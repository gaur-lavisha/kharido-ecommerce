package com.kharido.ecommerce.product_service.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.kharido.ecommerce.product_service.entity.Product;
import com.kharido.ecommerce.product_service.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	private final ProductService service;

	public ProductController(ProductService service) {
		this.service = service;
	}

	@PostMapping
	public Product save(@RequestBody Product p) {
		return service.save(p);
	}

	@GetMapping("/{id}")
	public Product get(@PathVariable(value = "id") Long id) {
		return service.get(id);
	}

	@GetMapping
	public List<Product> all() {
		return service.all();
	}

}
