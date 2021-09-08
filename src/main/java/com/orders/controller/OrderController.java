package com.orders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.orders.model.Order;
import com.orders.model.OrderStatus;
import com.orders.service.OrderService;

//import com.bezkoder.spring.files.excel.helper.ExcelHelper;
//import antlr.collections.List;

//@CrossOrigin(origins = {"http://localhost:3001","http://localhost:3000","http://localhost:3002"})
@RestController
@RequestMapping("/orders")
//@CrossOrigin(origins="*", value = {"*"}, exposedHeaders = {"Content-Disposition"})
@CrossOrigin(origins = "*", methods = {RequestMethod.POST,RequestMethod.OPTIONS}, allowedHeaders = {"Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method", "Access-Control-Request-Headers"}, exposedHeaders = {"Content-Disposition","Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"})
public class OrderController {

	@Autowired
	OrderService orderService;

//	@Autowired
//	OrderRepo orderRepo;

	@GetMapping("/allorders")
	public List<Order> getOrders()
	{
		return orderService.allOrders();

	}
	
	@GetMapping("/all-order-status")
	public OrderStatus[] getOrderStatus()
	{
		return OrderStatus.values();

	}

	@PostMapping("/saveorder")
	public void saveOrder(@RequestBody Order order)
	{
		orderService.saveOrder(order);
	}
	
	//custom query get by orderId
	@GetMapping("/orderid")
	@ResponseBody
	public List<Order> getbyOrderId(@RequestParam int orderId) {
		return orderService.getbyOrderId(orderId);
	}

	//custom query get by orderId and fr Id
	@GetMapping("/ids")
	@ResponseBody
	public Order getbyOrderIdAndFrId(@RequestParam int orderId, @RequestParam String frId)
	{
		return orderService.getbyOrderIdAndFrId(orderId, frId);
	}

	//	@GetMapping("/orderspage")
	//	Page<Order> paginate(Pageable pageable)
	//	{
	//		return orderRepo.findAll(pageable);
	//	}


	
	//getting paginated all data without filtering

	@GetMapping("/orderspage")
	@ResponseBody
	public Page<Order> paginate(@RequestParam int pageNum,@RequestParam int pageSize){

		return orderService.paginate(pageNum,pageSize);
	}



	//custom query  pagination based on filtering orderID

	@GetMapping("/paginate/ids")
	@ResponseBody
	public Page<Order> paginateOrderIdAndFrId(@RequestParam int orderId, @RequestParam int pageNum,@RequestParam int pageSize)
	{
		return orderService.paginateOrderId(orderId,pageNum,pageSize);
	}
	
	
	@PostMapping(path="upload")
	public List<Order> reaadXl(@RequestParam("file")  MultipartFile file)
	{
		System.out.println(file.getOriginalFilename());
		
//		if (ExcelHelper.hasExcelFormat(file)) {
//			System.out.println("");
//		}
		
		return null;
		
	}
}
