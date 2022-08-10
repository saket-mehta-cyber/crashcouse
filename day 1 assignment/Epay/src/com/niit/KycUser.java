package com.niit;

public class KycUser extends User {

	private int rewardPoint;
	
	public KycUser(int id, String username, String email, double walletBalance) {
		super(id, username, email, walletBalance);
		// TODO Auto-generated constructor stub
	}

	public int getRewardPoint() {
		return rewardPoint;
	}

	public void setRewardPoint(int rewardPoint) {
		this.rewardPoint = rewardPoint;
	}
	
	public boolean makePayment(double billAmount) {
		if(super.makePayment(billAmount)) {
			rewardPoint= (int) (rewardPoint+ billAmount*0.10);
			return true;
		}
		return false;
	}

	
}
