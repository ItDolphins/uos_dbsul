package com.example.demo.service.order;

import com.example.demo.model.Order;

import java.util.List;

public interface OrderService {

	List<Order> getOrderList(int store_no);
	Order getOrder(int order_no);
}