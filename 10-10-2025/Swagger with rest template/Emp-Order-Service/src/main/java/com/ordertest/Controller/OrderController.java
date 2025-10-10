package com.ordertest.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ordertest.Model.Order;

@RestController
@RequestMapping("/Order")
public class OrderController {
	@GetMapping("/{id}")
	public Order getOrderById(@PathVariable("id")int id) {
		return new Order(id,"laptop",20000.00);
	}

}
