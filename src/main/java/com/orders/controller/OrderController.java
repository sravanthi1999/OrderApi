package com.orders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.orders.model.Order;
import com.orders.service.OrderService;

//import antlr.collections.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("/allorders")
	public List<Order> getOrders()
	{
		return orderService.allOrders();
		
	}
	
	@PostMapping("/saveorder")
	public void saveOrder(@RequestBody Order order)
	{
		orderService.saveOrder(order);
	}

	@GetMapping("/orderid")
	@ResponseBody
	public List<Order> getbyOrderId(@RequestParam int orderId) {
		return orderService.getbyOrderId(orderId);
	}
	
	@GetMapping("/ids")
	@ResponseBody
	public Order getbyOrderIdAndFrId(@RequestParam int orderId, @RequestParam String frId)
	{
		return orderService.getbyOrderIdAndFrId(orderId, frId);
	}
}
