/* 
 *-The problem-
 *	ACME company is a start up and right now it is going to has its first month working.
 *	They have just a manager and another few employees.
 *	The owner want to know how much money he should invest in the montly payroll, including
 *	all employees in the company.
 *
 *-Solution-
 *	You must create a data structure (tree) for this solution, and you must use a recursive method.
 *
 *-My solution-
 *	In this exercise we are using a recursive method.
 *
 *	call#1
 *	manager(5200) 
 *	
 *		Call#2
 *		manager(5200) + technicianOne(1000)
 *	
 *			Call#3 
 *			manager(5200) + technicianOne(1000) + technicianTwo(2000) 
 *	
 *				and so on ...
 *	
 *						Call#
 *						stop criteria
 *	
 *	Monthly payroll:15200.0
 *
 *
 *-author-
 *	Mikel Solabarrieta (05 feb 2016)
 */
public class GetMonthlyPayroll {
	
	public static void main(String[] args) {
		Employee manager = new Employee(5200);
		
		Employee technicianOne = new Employee(1000);
		Employee technicianTwo = new Employee(2000);
		Employee technicianThree = new Employee(3000);
		Employee technicianFour = new Employee(4000);

		manager.addEmployee(technicianOne);
		manager.addEmployee(technicianTwo);
		manager.addEmployee(technicianThree);
		manager.addEmployee(technicianFour);

		Company company = new Company(manager);

		System.out.println("Monthly payroll:" + company.totalAmountMonthlyPayroll());
	}
}
