package com.example.demo.service.order;

import com.example.demo.model.Orderprod;

import java.util.List;

public interface OrderprodService {
	List<Orderprod> getOrderprodList(String order_no);

}
