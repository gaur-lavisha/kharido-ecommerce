package com.kharido.ecommerce.order_service.service;

import org.springframework.stereotype.Service;

import com.kharido.ecommerce.order_service.dto.ProductResponse;
import com.kharido.ecommerce.order_service.entity.Order;
import com.kharido.ecommerce.order_service.repository.OrderRepository;

@Service
public class OrderService {

	private final OrderRepository repo;

	private final ProductClient client;

	public OrderService(OrderRepository repo, ProductClient client) {
		this.repo = repo;
		this.client = client;
	}

	public Order create(Long productId, Integer qty) {

		ProductResponse p = client.get(productId);

		Order o = new Order();

		o.setProductId(productId);

		o.setQuantity(qty);

		o.setTotalPrice(p.price() * qty);

		return repo.save(o);

	}

}
