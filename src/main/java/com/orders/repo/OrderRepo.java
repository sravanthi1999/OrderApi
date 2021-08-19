package com.orders.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.orders.model.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order,Integer>
{
	@Query(value = "select * from orders where order_id=?1",nativeQuery = true)
	public List<Order> OrderId(@Param("orderId") int orderId);
	
	@Query(value = "select * from orders where order_id=?1 and fr_id=?2",nativeQuery = true)
	public Order OrderIdFrId(@Param("orderId") int orderId,@Param("frId") String frId);	

	@Query(value = "select * from orders where order_id=?1",nativeQuery = true)
	public Page<Order> pagingById(int orderId, Pageable pageable);

}
