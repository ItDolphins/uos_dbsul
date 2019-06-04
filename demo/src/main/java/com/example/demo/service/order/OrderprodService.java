package com.example.demo.service.order;

import com.example.demo.model.Orderprod;

import java.util.List;

public interface OrderprodService {
	List<Orderprod> getOrderprodList(int order_no);
	void insertOrderprod(Orderprod orderprod);
	void updateOrderprod(Orderprod orderprod);
	void deleteOrderprods(int order_no);

}
