package com.example.demo.repository.order;

import com.example.demo.model.Order;

import java.util.List;

public interface OrderDao {

	List<Order> findByStore_no(int store_no);
	Order getByOrder_no(int order_no );
}