package com.kirti.foodplaza.pojo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_22063")
public class Order {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	private String custEmailId;
	private double totalAmount;
	private LocalDateTime orderDateTime;
	private String orderStatus = "Processing";

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Order(String custEmailId, double totalAmount, LocalDateTime orderDateTime) {
		super();
		this.custEmailId = custEmailId;
		this.totalAmount = totalAmount;
		this.orderDateTime = orderDateTime;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustEmailId() {
		return custEmailId;
	}

	public void setCustEmailId(String custEmailId) {
		this.custEmailId = custEmailId;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LocalDateTime getOrderDateTime() {
		return orderDateTime;
	}

	public void setOrderDateTime(LocalDateTime orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", custEmailId=" + custEmailId + ", totalAmount=" + totalAmount
				+ ", orderDateTime=" + orderDateTime + ", orderStatus=" + orderStatus + "]";
	}

}
