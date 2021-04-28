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
			System.out.println("OutClass num = " + num + "(�ܺ� Ŭ������ �ν��Ͻ� ����)");
			System.out.println("OutClass num = " + sNum + "(�ܺ� Ŭ������ ����ƽ ����)");
			System.out.println("OutClass num = " + iNum + "(���� Ŭ������ �ν��Ͻ� ����)");
		}

	}
	
	public void usingClass() {
		inClass.inTest();
	}
	
	static class InStaticClass{
		
		int iNum = 100;
		static int sInNum = 200;
		
		void inTest() {
			System.out.println("InClass num = " + iNum + "(���� Ŭ������ �ν��Ͻ� ����)");
			System.out.println("OutClass num = " + sNum + "(�ܺ� Ŭ������ ����ƽ ����)");
			System.out.println("InClass num = " + sInNum + "(���� Ŭ������ ����ƽ ����)");
		}
		
		static void sTest() {
			System.out.println("OutClass num = " + sNum + "(�ܺ� Ŭ������ ����ƽ ����)");
			System.out.println("InClass num = " + sInNum + "(���� Ŭ������ ����ƽ ����)");
		}
		
	}

}

public class InnerTest {

	public static void main(String[] args) {
		
//		OutClass outClass = new OutClass();
//		outClass.usingClass();
//	
//		OutClass.InClass inner = outClass.new InClass();	// InClass�� private
//		inner.inTest();
		
		OutClass.InStaticClass.sTest();
		OutClass.InStaticClass sInClass = new OutClass.InStaticClass();
		sInClass.inTest();
		
	}
}
