package ch13;

import java.io.IOException;
import java.io.InputStreamReader;

public class SystemInTest {

	public static void main(String[] args) {
		System.out.println("문자를 쓰고 [Enter]를 누르세요");
		
		int i;
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			while((i = isr.read()) != '\n') {
				System.out.print((char)i);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
}
