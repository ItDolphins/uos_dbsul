package com.example.demo.controller;


import com.example.demo.model.Account;
import com.example.demo.model.Order;
import com.example.demo.model.Orderprod;
import com.example.demo.service.order.OrderService;
import com.example.demo.service.order.OrderprodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class OrderController {

	@Autowired
	OrderService orderService;

	@Autowired
	OrderprodService orderprodService;

	@GetMapping("/manage_order")
	public ModelAndView manage_order(ModelAndView mav) {
		Account account = (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<Order> orderList = orderService.getOrderList(account.getStore_no());

		mav.addObject("orderList", orderList);
		mav.setViewName("order/manage_order");

		return mav;
	}

	@RequestMapping("/manage_orderprod")
	public ModelAndView manage_orderpord(ModelAndView mav, HttpServletRequest request) {

		String order_no = request.getParameter("order_no");

		Order order = orderService.getOrder(order_no);
		List<Orderprod> orderprodList = orderprodService.getOrderprodList(order_no);

		mav.addObject("order", order);
		mav.addObject("orderprodList", orderprodList);
		mav.setViewName("order/manage_orderprod");
		return mav;
	}


}