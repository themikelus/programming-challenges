public class Company {
	
	private Employee manager;
	private double totalAmount;

	public Company(Employee manager) {
		this.manager = manager;
	}

	public Employee getManager() {
		return this.manager;
	}

	public double totalAmountMonthlyPayroll() {
		return this.totalAmountMonthlyPayroll(this.manager);
	}

	private double totalAmountMonthlyPayroll(Employee employee) {
		if(employee.getUnderMyResponsability().size() > 0) {
			for(Employee e : employee.getUnderMyResponsability()) {
				totalAmountMonthlyPayroll(e);
			}
		}
		
		return totalAmount += employee.getSalary();
	}
}