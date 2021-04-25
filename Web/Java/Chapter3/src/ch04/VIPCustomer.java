package ch04;

public class VIPCustomer extends Customer{
	
	double salesRatio;
	private int agentID;
	
	public VIPCustomer() {
		bonusRatio = 0.05;
		salesRatio = 0.1;
		customerGrade = "VIP";
	}
	
	@Override
	public int calcPrice(int price) {
		bonusPoint += price * bonusRatio;
		price -= (int)(price * salesRatio);
		
		return super.calcPrice(price);
	}

	public int getAgentID() {
		return agentID;
	}
}
