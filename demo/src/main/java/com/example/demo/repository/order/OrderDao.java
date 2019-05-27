package com.example.demo.repository.order;

import com.example.demo.model.Order;

import java.util.List;

public interface OrderDao {

	List<Order> findByStore_no(String store_no);
	Order getByOrder_no(String order_no );
}
