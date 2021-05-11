package ch07;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TravelTest {

	public static void main(String[] args) {

		TravelCustomer customerLee = new TravelCustomer("ÀÌ¼ø½Å", 40, 100);
		TravelCustomer customerKim = new TravelCustomer("±èÀ¯½Å", 20, 100);
		TravelCustomer customerHong = new TravelCustomer("È«±æµ¿", 13, 50);
		
		List<TravelCustomer> customerList = new ArrayList<TravelCustomer>();
		customerList.add(customerLee);
		customerList.add(customerKim);
		customerList.add(customerHong);

		System.out.println("°í°´ ¸í´Ü");
		customerList.stream().map(c->c.getName()).forEach(s->System.out.println(s));
		
		System.out.println("ÃÑºñ¿ë");
		System.out.println(customerList.stream().mapToInt(c->c.getCost()).sum());
		
		System.out.println("20¼¼ ÀÌ»ó °í°´ ¸í´Ü");
		customerList.stream().filter(s->s.getAge()>=20).map(c->c.getName()).sorted().forEach(s->System.out.println(s));
	}

}
