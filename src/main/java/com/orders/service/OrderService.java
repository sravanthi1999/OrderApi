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

	//custom query get by orderId
	public List<Order> getbyOrderId(int orderId)
	{
		return orderRepo.OrderId(orderId);
	}

	//custom query get by order and fr ID's
	public Order getbyOrderIdAndFrId(int orderId,String frId)
	{
		return orderRepo.OrderIdFrId(orderId, frId);
	}
	
	

	//getting paginated data without filtering

	public Page<Order> paginate(int pageNum, int pageSize) {

		Pageable pageable=PageRequest.of(pageNum, pageSize);
		Page<Order> resPage=orderRepo.findAll(pageable);

		return resPage;
	}


	//custom query  pagination based on filtering orderID

	public Page<Order> paginateOrderId(int orderId,int pageNum, int pageSize) {

		Pageable pageable=PageRequest.of(pageNum, pageSize);
		Page<Order> resPage=orderRepo.pagingById(orderId,pageable);

		return resPage;		
	}

}



//
//{
//   
//    "pageable": 
//    {
//        "sort": 
//        {
//            "sorted": false,
//            "unsorted": true,
//            "empty": true
//        },
//        "offset": 1,
//        "pageNumber": 0,
//        "pageSize": 1,
//        "paged": true,
//        "unpaged": false
//    },
//    "last": true,
//    "totalElements": 2,
//    "totalPages": 2,
//    "size": 1,
//    "number": 1,
//    "sort": 
//    {
//        "sorted": false,
//        "unsorted": true,
//        "empty": true
//    },
//    "first": false,
//    "numberOfElements": 1,
//    "empty": false
//}



