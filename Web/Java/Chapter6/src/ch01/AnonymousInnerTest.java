package ch01;

class Outter1{
	
	int outNum = 100;
	static int sNum = 200;
	
		
	Runnable getRunnable(int i){

		int num = 100;
		
		class MyRunnable implements Runnable{

			int localNum = 10;
				
			@Override
			public void run() {
				//num = 200;   //���� ��. ���������� ����� �ٲ�
				//i = 100;     //���� ��. �Ű� ���� ���� ��������ó�� ����� �ٲ�
				System.out.println("i =" + i); 
				System.out.println("num = " +num);  
				System.out.println("localNum = " +localNum);
					
				System.out.println("outNum = " + outNum + "(�ܺ� Ŭ���� �ν��Ͻ� ����)");
				System.out.println("Outter.sNum = " + Outter1.sNum + "(�ܺ� Ŭ���� ���� ����)");
				}
			}
		 return new MyRunnable();
	}
}

class Outter2{
	
	Runnable getRunnable(int i){

		int num = 100;
		
		return new Runnable() {
				
		@Override
		public void run() {
			//num = 200;   //���� ��
			//i = 10;      //���� ��
			System.out.println(i);
			System.out.println(num);
			}
		};
	}
	
	Runnable runner = new Runnable() {
		
		@Override
		public void run() {
			System.out.println("Runnable �� ������ �͸� Ŭ���� ����");
			
		}
	};
}


public class AnonymousInnerTest {
	
	public static void main(String[] args) {
		Outter1 out = new Outter1();
		Runnable runner = out.getRunnable(100);		// getRunnable �Լ� ���� -> Stack���� ����
	
		runner.run();								// num, i�� final�� ����Ǿ� Data���� ������
		
		Outter2 out2 = new Outter2();
		
		Runnable runnerble = out2.getRunnable(10);
		runnerble.run();
		
		out2.runner.run();

	}
}
