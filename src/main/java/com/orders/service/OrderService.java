package com.orders.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

	public List<Order> paginate(int pageNum, int pageSize) {
		
		Pageable pageable=PageRequest.of(pageNum, pageSize);
		Page<Order> resPage=orderRepo.findAll(pageable);
		
		return resPage.getContent();
	}

	public List<Order> paginateOrderId(int orderId,int pageNum, int pageSize) {
		
		Pageable pageable=PageRequest.of(pageNum, pageSize);
		Page<Order> resPage=orderRepo.pagingById(orderId,pageable);
		
		return resPage.getContent();		
	}
	
}
