package com.example.orderservice.controller;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderservice.entity.Order;
import com.example.orderservice.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	private static final Logger logger = Logger.getLogger(OrderController.class.getName());

	@Autowired
	private OrderService orderService;

	@PostMapping
	public Order createOrder(@RequestBody Order order) {
		logger.info("Creating order: " + order);
		return orderService.createOrder(order);
	}

	@PutMapping("/{id}/status")
	public Order updateOrderStatus(@PathVariable Long id, @RequestBody String status) {
		logger.info("Updating order status for order ID: " + id);
		return orderService.updateOrderStatus(id, status);
	}

	@GetMapping
	public List<Order> getAllOrders() {
		logger.info("Getting all orders");
		return orderService.getAllOrders();
	}

	@GetMapping("/{id}")
	public Optional<Order> getOrderById(@PathVariable Long id) {
		logger.info("Getting order by ID: " + id);
		return orderService.getOrderById(id);
	}

}
