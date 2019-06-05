package com.example.demo.controller;


import com.example.demo.dto.WrhsInfo;
import com.example.demo.model.*;
import com.example.demo.service.busireq.BusireqService;
import com.example.demo.service.busireq.WrhsInfoService;
import com.example.demo.service.order.OrderService;
import com.example.demo.service.order.OrderprodService;
import com.example.demo.service.prod.ProdService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {

	@Autowired
	OrderService orderService;

	@Autowired
	OrderprodService orderprodService;

	@Autowired
	ProdService prodService;

	@Autowired
	BusireqService busireqService;

	@Autowired
	WrhsInfoService wrhsInfoService;

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

		int order_no = Integer.parseInt(request.getParameter("order_no"));

		Order order = orderService.getOrder(order_no);
		List<Orderprod> orderprodList = orderprodService.getOrderprodList(order_no);

		mav.addObject("order", order);
		mav.addObject("orderprodList", orderprodList);
		mav.setViewName("order/manage_orderprod");
		return mav;
	}


	@GetMapping("/add_order_form")
	public ModelAndView add_order_form(ModelAndView mav) {

		List<Prod> prodList = prodService.getProdList();

		mav.addObject("prodList", prodList);
		mav.setViewName("order/add_order_form");
		return mav;
	}

	@Data
	@NoArgsConstructor
	public static class OrderprodWrapper {
		private int prod_no;
		private int prod_qnt;
	}

	@RequestMapping(value ="/add_order_process", method = RequestMethod.POST)
	@ResponseBody
	public String add_order_process(@RequestBody List<OrderprodWrapper> requests) {
		Account account = (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Order order = new Order(account.getStore_no());
		orderService.insertOrder(order);
		int order_no = orderService.getOrderByOrder_state(order.getStore_no(), order.getOrder_state()).get(0).getOrder_no();
		Orderprod orderprod  = new Orderprod();
		orderprod.setOrder_no(order_no);
		for (int i = 0; i<requests.size(); i++){
			OrderprodWrapper opw = requests.get(i);
			orderprod.setProd_no(opw.getProd_no());
			orderprod.setProd_qnt(opw.getProd_qnt());
			orderprodService.insertOrderprod(orderprod);
		}
		order.setOrder_state("발주신청중");
		order.setOrder_no(order_no);
		orderService.updateOrder(order);
		return null;

	}

	@GetMapping("/alter_orderprod_form")
	public ModelAndView alter_orderprod_form(ModelAndView mav,  HttpServletRequest request) {
		int order_no = Integer.parseInt(request.getParameter("order_no"));

		List<Orderprod> orderprodList = orderprodService.getOrderprodList(order_no);
		List<Prod> prodList = prodService.getProdList();

		mav.addObject("order_no", order_no);
		mav.addObject("orderprodList", orderprodList);
		mav.addObject("prodList", prodList);
		mav.setViewName("order/alter_orderprod_form");
		return mav;
	}

	@RequestMapping(value ="/alter_orderprod_process", method = RequestMethod.POST)
	@ResponseBody
	public String alter_orderprod_process(@RequestBody List<OrderprodWrapper> requests,  HttpServletRequest request) {
		int order_no = Integer.parseInt(request.getParameter("order_no"));
		orderprodService.deleteOrderprods(order_no);
		Orderprod orderprod  = new Orderprod();
		orderprod.setOrder_no(order_no);
		for (int i = 0; i<requests.size(); i++){
			OrderprodWrapper opw = requests.get(i);
			orderprod.setProd_no(opw.getProd_no());
			orderprod.setProd_qnt(opw.getProd_qnt());
			orderprodService.insertOrderprod(orderprod);
		}
		return null;
	}

	@GetMapping("/search_busireq")
	public ModelAndView search_busireq(ModelAndView mav) {
		Account account = (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int store_no = account.getStore_no();
		List<Order> orderList = orderService.getOrderList(store_no);
		List<Busireq> busireqList = new ArrayList<Busireq>();
		for (Order order : orderList){
			busireqList.addAll(busireqService.getBusireqList(order.getOrder_no()));
		}

		mav.addObject("busireqList", busireqList);
		mav.setViewName("order/search_busireq");
		return mav;
	}

	@GetMapping("/search_wrhsInfo")
	public ModelAndView search_wrhsInfo(ModelAndView mav) {
		Account account = (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int store_no = account.getStore_no();
		List<WrhsInfo> wrhsInfoList = wrhsInfoService.getWrhsInfoList(store_no);

		mav.addObject("wrhsInfoList", wrhsInfoList);
		mav.setViewName("order/search_wrhsInfo");
		return mav;
	}
}