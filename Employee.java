package Streams;

public class Employee {
	int Employee_id;
	String employee_Name;
	double salary;
	String Designation;
	int age;

	public Employee(int employee_id, String employee_Name, double salary, String designation, int age) {
		super();
		Employee_id = employee_id;
		this.employee_Name = employee_Name;
		this.salary = salary;
		Designation = designation;
		this.age = age;
	}

	public int getEmployee_id() {
		return Employee_id;
	}

	public void setEmployee_id(int employee_id) {
		Employee_id = employee_id;
	}

	public String getEmployee_Name() {
		return employee_Name;
	}

	public void setEmployee_Name(String employee_Name) {
		this.employee_Name = employee_Name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [Employee_id=" + Employee_id + ", employee_Name=" + employee_Name + ", salary=" + salary
				+ ", Designation=" + Designation + ", age=" + age + "]";
	}

}
