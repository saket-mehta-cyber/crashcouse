package com.niit.os.api.service;

import org.hibernate.sql.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.niit.os.api.common.Payment;
import com.niit.os.api.common.TransactionRequest;
import com.niit.os.api.common.TransactionResponse;
import com.niit.os.api.entity.Order;
import com.niit.os.api.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public TransactionResponse saveOrder(TransactionRequest transactionRequest) {
		String response="";
		Order order=transactionRequest.getOrder();
		Payment payment=transactionRequest.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		
		// Rest call
		
		Payment paymentResponse= restTemplate.postForObject("http://PAYMENT-SERVICE/payment/doPayment", payment, Payment.class);
		
		response=paymentResponse.getPaymentStatus().equals("success")?"payment success order placed":"payment failed order added to cart";
		 orderRepository.save(order);
		 return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(), response);
	}
	
}
