package ch16;

public class EmployeeTest {

	public static void main(String[] args) {
		
		Employee employeeLee = new Employee();
		employeeLee.setEmployeeName("이순신");
		
		System.out.println(employeeLee.serialNum);

		Employee employeeKim = new Employee();
		employeeKim.setEmployeeName("김무성");
		
		System.out.println(employeeKim.serialNum);
	}

}
