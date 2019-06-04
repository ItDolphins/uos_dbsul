package com.example.demo.service.order;

import com.example.demo.model.Order;

import java.util.List;

public interface OrderService {

	List<Order> getOrderList(int store_no);
	Order getOrder(int order_no);
	Order getOrderByOrder_state(int store_no, String order_state);
	void insertOrder(Order order);
	void updateOrder(Order order);
}