package ch01;

class OutClass{
	
	private int num = 10;
	private static int sNum = 50;
	private InClass inClass;
	
	public OutClass(){
		inClass = new InClass();
	}
	
	class InClass{
		
		int iNum = 100;
//		static int sInNum = 500;
		
		void inTest() {
			System.out.println("OutClass num = " + num + "(외부 클래스의 인스턴스 변수)");
			System.out.println("OutClass num = " + sNum + "(외부 클래스의 스태틱 변수)");
			System.out.println("OutClass num = " + iNum + "(내부 클래스의 인스턴스 변수)");
		}

	}
	
	public void usingClass() {
		inClass.inTest();
	}
	
	static class InStaticClass{
		
		int iNum = 100;
		static int sInNum = 200;
		
		void inTest() {
			System.out.println("InClass num = " + iNum + "(내부 클래스의 인스턴스 변수)");
			System.out.println("OutClass num = " + sNum + "(외부 클래스의 스태틱 변수)");
			System.out.println("InClass num = " + sInNum + "(내부 클래스의 스태틱 변수)");
		}
		
		static void sTest() {
			System.out.println("OutClass num = " + sNum + "(외부 클래스의 스태틱 변수)");
			System.out.println("InClass num = " + sInNum + "(내부 클래스의 스태틱 변수)");
		}
		
	}

}

public class InnerTest {

	public static void main(String[] args) {
		
//		OutClass outClass = new OutClass();
//		outClass.usingClass();
//	
//		OutClass.InClass inner = outClass.new InClass();	// InClass가 private
//		inner.inTest();
		
		OutClass.InStaticClass.sTest();
		OutClass.InStaticClass sInClass = new OutClass.InStaticClass();
		sInClass.inTest();
		
	}
}
