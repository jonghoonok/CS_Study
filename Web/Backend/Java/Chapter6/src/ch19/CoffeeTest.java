package ch19;

public class CoffeeTest {

	public static void main(String[] args) {
		Coffee espresso = new Espresso();
		espresso.brewing();
		System.out.println();
		
		Coffee latte = new Latte(espresso);
		latte.brewing();
		System.out.println();

		Coffee mocha = new Mocha(new Latte(espresso));
		mocha.brewing();
		System.out.println();
		
	}
}
