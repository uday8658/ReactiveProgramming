package com.reactive.reactiveprogramming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactive.reactiveprogramming.model.Order;
import com.reactive.reactiveprogramming.repo.OrderRepo;

import reactor.core.publisher.Flux;


@Service
public class OrderServiceImp implements OrderService {
	
	@Autowired
	private OrderRepo orderRepo;

	@Override
	public Flux<Order> getAllOrder(long id) {
		
		return orderRepo.findAll();
	}

}
