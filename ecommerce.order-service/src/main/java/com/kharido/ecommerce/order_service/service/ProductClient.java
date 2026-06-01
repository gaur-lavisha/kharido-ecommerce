package com.kharido.ecommerce.order_service.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.kharido.ecommerce.order_service.dto.ProductResponse;

@Service
public class ProductClient {

	private final RestClient client;
	private final String productUrl;

	public ProductClient(@Value("${services.product.url}") String productUrl) {
		this.productUrl = productUrl;
		this.client = RestClient.create();
	}

	public ProductResponse get(Long id) {

		return client.get().uri(productUrl + "/products/" + id).retrieve().body(ProductResponse.class);
	}
}
