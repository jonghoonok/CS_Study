package ch06;

public class StudentTest {

	public static void main(String[] args) {
		Student studentLee = new Student();
		System.out.println(studentLee.showStudentInfo());

		Student studentOk = new Student(201310913, "ø¡¡æ»∆", 7);
		System.out.println(studentOk.showStudentInfo());
	}

}
