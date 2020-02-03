package com.reactive.reactiveprogramming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.reactiveprogramming.model.Order;
import com.reactive.reactiveprogramming.service.OrderService;

import reactor.core.publisher.Flux;

@RestController
public class OrderController {
	
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/getAll")
	Flux<Order> findAll(@RequestAttribute long id)
	{
		return orderService.getAllOrder(id);
	}
	

}
