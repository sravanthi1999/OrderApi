package com.orders.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orders")
//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
public class Order {
	
	
	int orderId;
	@Id	
	String frId;
	String poNum;
	String orderStatus;
	String orderFlowType;
	String orderInputChannel;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getFrId() {
		return frId;
	}
	public void setFrId(String frId) {
		this.frId = frId;
	}
	public String getPoNum() {
		return poNum;
	}
	public void setPoNum(String poNum) {
		this.poNum = poNum;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderFlowType() {
		return orderFlowType;
	}
	public void setOrderFlowType(String orderFlowType) {
		this.orderFlowType = orderFlowType;
	}
	public String getOrderInputChannel() {
		return orderInputChannel;
	}
	public void setOrderInputChannel(String orderInputChannel) {
		this.orderInputChannel = orderInputChannel;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", frId=" + frId + ", poNum=" + poNum + ", orderStatus=" + orderStatus
				+ ", orderFlowType=" + orderFlowType + ", orderInputChannel=" + orderInputChannel + "]";
	}
	
	
	
	
	

}
