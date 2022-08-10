package com.niit;

public class EPayWallet {

	public static void processPaymentByUser(User user, double billAmount) {
		if (user instanceof KycUser) {
			KycUser kycUser = (KycUser) user;
			if (kycUser.makePayment(billAmount)) {
				System.out
						.println("Congrats " + kycUser.getUsername() + " payment of " + billAmount + " was successfull");
			} else {
				System.out.println("Sorry " + kycUser.getUsername() + " not enough balance to make payment");
			}

			System.out.println("Your wallet balance is " + kycUser.getWalletBalance());
			System.out.println("You have " + kycUser.getRewardPoint() + " reward points");

		} else {
			if (user.makePayment(billAmount)) {
				System.out.println("Congrats " + user.getUsername() + " payment of " + billAmount + " was successfull");
			} else {
				System.out.println("Sorry " + user.getUsername() + " not enough balance to make payment");
			}
			System.out.println("Your wallet balance is " + user.getWalletBalance());
		}

	}
}
