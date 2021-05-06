package ch23;

import java.util.ArrayList;

class FastLibrary {

	public ArrayList<String> shelf = new ArrayList<String>();
	
	public FastLibrary() {
		shelf.add("해리포터 1");
		shelf.add("해리포터 2");
		shelf.add("해리포터 3");
	}
	
	public synchronized String lendBook() throws InterruptedException {
		Thread t = Thread.currentThread();
		
		while(shelf.size() == 0) {
			System.out.println(t.getName() + " waits...");
			wait();
			System.out.println(t.getName() + " waiting end");
		}
		String book = shelf.remove(0);
		System.out.println(t.getName() + " lent " + book);
		
		return book;
	}
	
	public synchronized void returnBook(String book){
		Thread t = Thread.currentThread();
		
		shelf.add(book);
		notifyAll();
		System.out.println(t.getName() + " return " + book);
	}

}

class Student extends Thread{
	
	public Student(String name) {
		super(name);
	}
	
	public void run(){

		try{
			String title = LibraryMain.library.lendBook();
			if( title == null ) return;
			sleep(2000);
			LibraryMain.library.returnBook(title);
			
		}catch (InterruptedException e) {
			System.out.println(e);
		}
	}
	
}


public class LibraryMain {
	
	public static FastLibrary library = new FastLibrary();
	public static void main(String[] args) {
		
		Student std1 = new Student("std1");
		Student std2 = new Student("std2");
		Student std3 = new Student("std3");
		Student std4 = new Student("std4");
		Student std5 = new Student("std5");
		Student std6 = new Student("std6");
		
		std1.start();
		std2.start();
		std3.start();
		std4.start();
		std5.start();
		std6.start();

	}
}