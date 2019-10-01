package com.nagarro.microservices.orderservice.beans;

import java.util.List;

import com.nagarro.microservices.orderservice.proxy.ProductBean;

public class Order {
	String orderId;
	List<ProductBean> products;
	Double totalCost;
	int sla;


	public Order() {
		super();
	}

	public Order(String orderId, List<ProductBean> products, Double totalCost) {
		super();
		this.orderId = orderId;
		this.products = products;
		this.totalCost = totalCost;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public List<ProductBean> getProducts() {
		return products;
	}

	public void setProducts(List<ProductBean> products) {
		this.products = products;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public int getSla() {
		return sla;
	}

	public void setSla(int sla) {
		this.sla = sla;
	}
	
	
}
