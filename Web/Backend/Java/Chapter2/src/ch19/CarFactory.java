package ch19;

public class CarFactory {
	
	private static CarFactory instance = new CarFactory();
	
	private static int serialNum = 10000;
	
	private CarFactory() {
		
	}
	
	public static int getSerialNum() {
		return serialNum;
	}

	public static CarFactory getInstance() {
		if(instance == null) {
			instance = new CarFactory();
		}
		return instance;
	}

	public Car createCar() {
		Car car = new Car();
		car.setCarNum(++serialNum);
		return car;
	}
}
