package com.example.demo.repository.order;

import com.example.demo.model.Orderprod;

import java.util.List;

public interface OrderprodDao {
	List<Orderprod> findByOrder_no(String order_no);
}
