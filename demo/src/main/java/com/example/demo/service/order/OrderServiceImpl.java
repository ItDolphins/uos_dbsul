package com.example.demo.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Order;
import com.example.demo.repository.order.OrderDao;

import java.util.List;

@Transactional
@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderDao orderDao;

	@Override
	public List<Order> getOrderList(int store_no){

		List<Order> orderList = orderDao.findByStore_no(store_no);
		return orderList;
	}

	@Override
	public 	Order getOrder(int order_no){
		Order order = orderDao.getByOrder_no(order_no);
		return order;
	}

}