package ch16;

public class EmployeeTest {

	public static void main(String[] args) {
		
		Employee employeeLee = new Employee();
		employeeLee.setEmployeeName("�̼���");
		
		System.out.println(employeeLee.serialNum);

		Employee employeeKim = new Employee();
		employeeKim.setEmployeeName("�蹫��");
		
		System.out.println(employeeKim.serialNum);
	}

}
