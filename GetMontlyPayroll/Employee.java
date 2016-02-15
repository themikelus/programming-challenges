import java.util.List;
import java.util.ArrayList;

public class Employee {
	
	private double salary;

	private List<Employee> underMyResponsability = new ArrayList<Employee>();

	public Employee(double salary) {
		this.salary = salary;
	}

	public void addEmployee(Employee employee) {
		this.underMyResponsability.add(employee);
	}

	public double getSalary() {
		return this.salary;
	}

	public List<Employee> getUnderMyResponsability() {
		return this.underMyResponsability;
	}
}
