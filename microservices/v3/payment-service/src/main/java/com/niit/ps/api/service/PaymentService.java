package com.niit.ps.api.service;



import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.ps.api.entity.Payment;
import com.niit.ps.api.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	
	public Payment doPayment(Payment payment) {
		payment.setPaymentStatus(paymentProcessing());
		payment.setTransactionId(UUID.randomUUID().toString());
		return paymentRepository.save(payment);
	}
	
	private String paymentProcessing() {
		return new Random().nextBoolean()?"success":"false";
	}

	public Payment findPAymentHistoryByOrderId(int orderId) {
		// TODO Auto-generated method stub
		return paymentRepository.findByOrderId(orderId);
	}
}
