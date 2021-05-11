package ch09;

public class Desktop extends Computer {

	@Override
	public void display() {
		System.out.println("display");
	}

	@Override
	public void typing() {
		System.out.println("type");
	}

}
