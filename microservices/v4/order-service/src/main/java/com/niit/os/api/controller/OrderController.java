package com.niit.os.api.controller;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.os.api.common.Payment;
import com.niit.os.api.common.TransactionRequest;
import com.niit.os.api.common.TransactionResponse;
import com.niit.os.api.entity.Order;
import com.niit.os.api.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/bookOrder")
	public TransactionResponse bookOrder(@RequestBody TransactionRequest transactionRequest) {
		
		return orderService.saveOrder(transactionRequest);
	}
}
