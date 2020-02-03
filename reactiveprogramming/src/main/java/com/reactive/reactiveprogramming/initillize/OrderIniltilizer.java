package com.reactive.reactiveprogramming.initillize;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

import com.reactive.reactiveprogramming.model.Order;
import com.reactive.reactiveprogramming.repo.OrderRepo;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Component
@Profile("!test")
@Slf4j
public class OrderIniltilizer implements CommandLineRunner {
	
	    @Autowired
	    OrderRepo orderRepo;
	    
	    @Autowired
	    MongoOperations mongoOperations;

	    @Override
	    public void run(String... args) throws Exception {

	        initalDataSetUp();
	    }
	  
	    public List<Order> data() {

	        return Arrays.asList(new Order(12334, "Samsung TV", "11-12-2020","usingh@nisum.com"),
	                new Order(12335, "Apple watch", "11-12-2020","usingh@nisum.com"),
	                new Order(12336, "POCO F1", "11-12-2020","usingh@nisum.com"),
	                new Order(12337, " Dell Laptop", "11-12-2020","usingh@nisum.com"));
	    }

	    private void initalDataSetUp() {

	        orderRepo.deleteAll()
	                .thenMany(Flux.fromIterable(data()))
	                        .flatMap(orderRepo::save)
	                        .thenMany(orderRepo.findAll())
	                        .subscribe((Order -> {
	                            System.out.println("Order inserted from CommandLineRunner : " + Order);
	                        }));
	    }

	}

