package com.kharido.ecommerce.order_service.controller;

import org.springframework.web.bind.annotation.*;

import com.kharido.ecommerce.order_service.entity.Order;
import com.kharido.ecommerce.order_service.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	private final OrderService service;

	public OrderController(OrderService service) {
		this.service = service;
	}

	@PostMapping
	public Order create(@RequestParam Long productId, @RequestParam Integer qty) {
		return service.create(productId, qty);
	}

}
