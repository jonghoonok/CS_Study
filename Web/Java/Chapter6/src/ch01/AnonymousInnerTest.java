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
				//num = 200;   //에러 남. 지역변수는 상수로 바뀜
				//i = 100;     //에러 남. 매개 변수 역시 지역변수처럼 상수로 바뀜
				System.out.println("i =" + i); 
				System.out.println("num = " +num);  
				System.out.println("localNum = " +localNum);
					
				System.out.println("outNum = " + outNum + "(외부 클래스 인스턴스 변수)");
				System.out.println("Outter.sNum = " + Outter1.sNum + "(외부 클래스 정적 변수)");
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
			//num = 200;   //에러 남
			//i = 10;      //에러 남
			System.out.println(i);
			System.out.println(num);
			}
		};
	}
	
	Runnable runner = new Runnable() {
		
		@Override
		public void run() {
			System.out.println("Runnable 이 구현된 익명 클래스 변수");
			
		}
	};
}


public class AnonymousInnerTest {
	
	public static void main(String[] args) {
		Outter1 out = new Outter1();
		Runnable runner = out.getRunnable(100);		// getRunnable 함수 종료 -> Stack에서 해제
	
		runner.run();								// num, i는 final로 선언되어 Data에서 가져옴
		
		Outter2 out2 = new Outter2();
		
		Runnable runnerble = out2.getRunnable(10);
		runnerble.run();
		
		out2.runner.run();

	}
}
