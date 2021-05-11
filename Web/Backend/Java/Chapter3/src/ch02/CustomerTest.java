package ch02;

public class CustomerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer customerLee = new Customer();
		customerLee.setCustomerName("Lee");
		customerLee.setCustomerID(10010);
		customerLee.bonusPoint = 1000;
		System.out.println(customerLee.showCustomerInfo());
		
		VIPCustomer customerKim = new VIPCustomer();
		customerKim.setCustomerName("KIM");
		customerKim.setCustomerID(10020);
		customerKim.bonusPoint = 20000;
		System.out.println(customerKim.showCustomerInfo());
	}

}
