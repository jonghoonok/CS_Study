package ch13;

import java.io.IOException;
import java.io.InputStreamReader;

public class SystemInTest {

	public static void main(String[] args) {
		System.out.println("���ڸ� ���� [Enter]�� ��������");
		
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
