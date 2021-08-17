package com.orders.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orders.model.Order;
import com.orders.repo.OrderRepo;


@Service
public class OrderService {

	@Autowired
	OrderRepo orderRepo;
	
	public List<Order> allOrders() {
		
		return orderRepo.findAll();
	}
	
	public void saveOrder(Order order) {
		orderRepo.save(order);
	}
	
	public List<Order> getbyOrderId(int orderId)
	{
		return orderRepo.OrderId(orderId);
	}
	
	public Order getbyOrderIdAndFrId(int orderId,String frId)
	{
		return orderRepo.OrderIdFrId(orderId, frId);
	}
	
}
