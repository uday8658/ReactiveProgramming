package com.reactive.reactiveprogramming.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.reactive.reactiveprogramming.model.Order;

public interface OrderRepo extends ReactiveMongoRepository<Order, Long> {

}
