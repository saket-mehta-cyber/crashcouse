package com.niit;

public class Tester {

	public static void main(String[] args) {
	
		User u1=new User(101, "Jack", "Jack@gmail.com", 1000);
		KycUser k1=new KycUser(201, "Jill", "Jill@gmail.com", 3000);
		
		EPayWallet.processPaymentByUser(u1, 700);
		EPayWallet.processPaymentByUser(k1, 1500);
		EPayWallet.processPaymentByUser(k1, 800);
		EPayWallet.processPaymentByUser(k1, 1200);

	}

}
