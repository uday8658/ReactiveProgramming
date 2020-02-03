package com.reactive.reactiveprogramming.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Order {
	
	@Id
	private long orderNumber;
	private String orderDetails;
	private String orderDate;
	private String Email;


}
