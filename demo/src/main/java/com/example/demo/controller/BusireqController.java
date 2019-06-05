package com.example.demo.controller;


import ch.qos.logback.core.net.SocketConnector;
import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.demo.dto.WrhsInfo;
import com.example.demo.model.*;
import com.example.demo.service.admin.AdminService;
import com.example.demo.service.busireq.BusireqService;
import com.example.demo.service.busireq.WrhsInfoService;
import com.example.demo.service.busireq.WrhsService;
import com.example.demo.service.order.OrderService;
import com.example.demo.service.order.OrderprodService;
import com.example.demo.service.stock.StockService;
import com.example.demo.service.store.StoreInfoService;
import com.sun.org.apache.xpath.internal.operations.Or;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class BusireqController {

	@Autowired
	OrderService orderService;

	@Autowired
	StoreInfoService storeInfoService;

	@Autowired
	OrderprodService orderprodService;

	@Autowired
	BusireqService busireqService;

	@Autowired
	WrhsService wrhsService;

	@Autowired
	StockService stockService;

	@Autowired
	WrhsInfoService wrhsInfoService;

	@GetMapping("/add_busireq")
	public ModelAndView add_busireq(ModelAndView mav) {
		Account account = (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<Integer> store_noList = storeInfoService.getStore_noList(account.getAdmin_no());
		List<Order> orderList = new ArrayList<Order>();
		for (int store_no : store_noList) {
			orderList.addAll(orderService.getOrderByOrder_state(store_no, "발주신청중"));
		}
		mav.addObject("orderList", orderList);
		mav.setViewName("busireq/add_busireq");
		return mav;
	}

	@RequestMapping("/lookup_orderprod")
	public ModelAndView lookup_orderpord(ModelAndView mav, HttpServletRequest request) {

		int order_no = Integer.parseInt(request.getParameter("order_no"));

		Order order = orderService.getOrder(order_no);
		List<Orderprod> orderprodList = orderprodService.getOrderprodList(order_no);

		mav.addObject("order", order);
		mav.addObject("orderprodList", orderprodList);
		mav.setViewName("busireq/lookup_orderprod");
		return mav;
	}

	@Data
	@NoArgsConstructor
	public static class Order_noWrapper {
		private int order_no;
	}

	@RequestMapping(value = "/req_order_process", method = RequestMethod.POST)
	@ResponseBody
	public String req_order_process(@RequestBody List<BusireqController.Order_noWrapper> requests) {
		Order order = new Order();
		List<Orderprod> orderprodList = new ArrayList<Orderprod>();
		for (int i = 0; i < requests.size(); i++) {
			BusireqController.Order_noWrapper opw = requests.get(i);
			order.setOrder_no(opw.getOrder_no());
			order.setOrder_state("발주처리중");
			orderService.updateOrder(order);
			orderprodList.addAll(orderprodService.getOrderprodList(opw.getOrder_no()));
		}
		Busireq busireq = new Busireq();
		for( Orderprod orderprod : orderprodList) {
			busireq.setOrder_no(orderprod.getOrder_no());
			busireq.setReq_qnt(orderprod.getProd_qnt());
			busireq.setProd_no(orderprod.getProd_no());
			busireqService.insertBusireq(busireq);
		}
		return null;

	}

	@GetMapping("/lookup_busireq")
	public ModelAndView lookup_busireq(ModelAndView mav) {
		Account account = (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<Integer> store_noList = storeInfoService.getStore_noList(account.getAdmin_no());
		List<Order> orderList = new ArrayList<Order>();
		for (int store_no : store_noList) {
			orderList.addAll(orderService.getOrderList(store_no));
		}
		List<Busireq> busireqList = new ArrayList<Busireq>();
		for (Order order : orderList){
			busireqList.addAll(busireqService.getBusireqList(order.getOrder_no()));
		}

		mav.addObject("busireqList", busireqList);
		mav.setViewName("busireq/lookup_busireq");
		return mav;
	}

	@GetMapping("/add_busireq_form")
	public ModelAndView add_busireq_form(ModelAndView mav) {
		Account account = (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<Integer> store_noList = storeInfoService.getStore_noList(account.getAdmin_no());
		List<Order> orderList = new ArrayList<Order>();
		for (int store_no : store_noList) {
			orderList.addAll(orderService.getOrderByOrder_state(store_no, "발주처리중"));
		}
		List<Busireq> busireqList = new ArrayList<Busireq>();
		for (Order order : orderList){
			busireqList.addAll(busireqService.getBusireqList(order.getOrder_no()));
		}

		mav.addObject("busireqList", busireqList);
		mav.setViewName("busireq/add_busireq_form");
		return mav;
	}

	@Data
	@NoArgsConstructor
	public static class Req_noWrapper {
		private int req_no;
	}

	@RequestMapping(value = "/delivReq", method = RequestMethod.POST)
	@ResponseBody
	public String delivReq(@RequestBody List<BusireqController.Req_noWrapper> requests) {

		Busireq busireq ;
		for (int i = 0; i < requests.size(); i++) {
			BusireqController.Req_noWrapper opw = requests.get(i);
			busireq = busireqService.getBusireq(opw.getReq_no());
			busireq.setOrder_date(new Date());
			busireq.setDeliv_state("배송요청중");
			busireqService.updateBusireq(busireq);
		}
		return null;
	}

	@RequestMapping(value = "/delivStart", method = RequestMethod.POST)
	@ResponseBody
	public String delivStart(@RequestBody List<BusireqController.Req_noWrapper> requests) {

		Busireq busireq ;
		for (int i = 0; i < requests.size(); i++) {
			BusireqController.Req_noWrapper opw = requests.get(i);
			busireq = busireqService.getBusireq(opw.getReq_no());
			busireq.setDeliv_date(new Date());
			busireq.setBusi_conf_flag("Y");
			busireq.setDeliv_state("배송시작");
			busireqService.updateBusireq(busireq);
		}
		return null;
	}

	@RequestMapping(value = "/wrhs_process", method = RequestMethod.POST)
	@ResponseBody
	public String wrhs_process(@RequestBody List<BusireqController.Req_noWrapper> requests) {
		Busireq busireq ;
		Order order;
		Wrhs wrhs;
		Stock stock;
		for (int i = 0; i < requests.size(); i++) {
			BusireqController.Req_noWrapper opw = requests.get(i);
			busireq = busireqService.getBusireq(opw.getReq_no());
			busireq.setDeliv_state("배송완료");
			busireqService.updateBusireq(busireq);
			order = orderService.getOrder(busireq.getOrder_no());
			wrhs = new Wrhs(opw.getReq_no());
			wrhsService.insertWrhs(wrhs);
			if( stockService.isStockExist(busireq.getProd_no(),wrhs.getExpdate(),order.getStore_no())) {
				stock = stockService.getStock(busireq.getProd_no(),wrhs.getExpdate(),order.getStore_no());
				stockService.updateStock(stock, stock.getStock_qnt() + busireq.getReq_qnt());
			}
			else {
				stock = new Stock(busireq.getProd_no(),wrhs.getExpdate(),order.getStore_no(),busireq.getReq_qnt());
				stockService.insertStock(stock);
			}
			if(busireqService.isAllDeliv_state(order.getOrder_no(),"배송완료")) {
				order.setOrder_state("발주확정");
				orderService.updateOrder(order);
			}
		}
		return null;
	}

	@GetMapping("/lookup_wrhsInfo")
	public ModelAndView lookup_wrhsInfo(ModelAndView mav) {
		Account account = (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<Integer> store_noList = storeInfoService.getStore_noList(account.getAdmin_no());
		List<WrhsInfo> wrhsInfoList = new ArrayList<WrhsInfo>();
		for (int store_no : store_noList) {
			wrhsInfoList.addAll(wrhsInfoService.getWrhsInfoList(store_no));
		}

		mav.addObject("wrhsInfoList", wrhsInfoList);
		mav.setViewName("busireq/lookup_wrhsInfo");
		return mav;
	}


}
