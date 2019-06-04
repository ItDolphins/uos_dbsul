package com.example.demo.repository.order;

import com.example.demo.model.Orderprod;

import java.util.List;

public interface OrderprodDao {
	List<Orderprod> findByOrder_no(int order_no);
	void insertOrderprod(Orderprod orderprod);
	void updateOrderprod(Orderprod orderprod);
	void deleteOrderprodByOrder_no(int order_no);
}
