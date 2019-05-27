package com.example.demo.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Order;
import com.example.demo.repository.order.OrderDao;

import java.util.List;


@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderDao orderDao;

	@Override
	public List<Order> getOrderList(String store_no){

		List<Order> orderList = orderDao.findByStore_no(store_no);
		return orderList;
	}

	@Override
	public 	Order getOrder(String order_no){
		Order order = orderDao.getByOrder_no(order_no);
		return order;
	}

}
