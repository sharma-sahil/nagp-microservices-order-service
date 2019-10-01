package com.nagarro.microservices.orderservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.microservices.orderservice.Configuration;
import com.nagarro.microservices.orderservice.beans.Order;
import com.nagarro.microservices.orderservice.constants.AppConstants;
import com.nagarro.microservices.orderservice.proxy.ProductBean;
import com.nagarro.microservices.orderservice.proxy.ProductServiceProxy;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class OrderServiceController {

	@Autowired
	ProductServiceProxy productServiceProxy;

	@Autowired
	Configuration configuration;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@GetMapping("/orders/{orderId}")
	public Order getOrderDetails(@PathVariable String orderId) {
		List<ProductBean> list = productServiceProxy.getProducts();
		Order result = new Order(orderId, list, 500d);
		result.setSla(configuration.getSla());

		rabbitTemplate.convertAndSend(AppConstants.TOPIC_EXCHANGE_NAME, AppConstants.ROUTING_KEY,
				"Received an order with ID : " + orderId);
		return result;
	}

	@GetMapping("/hysterixExample")
	@HystrixCommand(fallbackMethod = "fallbackGetOrders")
	public Order getOrders() {
		throw new RuntimeException("Hysterix Example");
	}

	public Order fallbackGetOrders() {
		List<ProductBean> list = new ArrayList<>();
		return new Order("fallback", list, -1d);
	}

}
