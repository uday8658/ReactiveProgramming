package com.reactive.reactiveprogramming.service;

import com.reactive.reactiveprogramming.model.Order;

import reactor.core.publisher.Flux;

public interface OrderService {
	
	Flux<Order> getAllOrder(long id);

}
