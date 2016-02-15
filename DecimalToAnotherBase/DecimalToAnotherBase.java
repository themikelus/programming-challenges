/* 
 *-The problem-
 *	We need a calculator-converter from decimal to any number of the follow range [0] to [9]. 
 *
 *-Solution-
 *	public static String solutionI(int number, int base)
 *	
 *	Where "int number" is a decimal number to be converted.
 *	Where "int base" is the new base number.
 *
 *	e.g.:
 *	number = 27 (decimal)
 *	base = 2  (to binary base)
 *
 *-My solution-
 *	In this exercise we are using a iterative method.
 *
 *	call#1
 *	number=27, base=2
 *	(27) decimal to binary (2) = 11011	  
 *
 *
 *-author-
 *	Mikel Solabarrieta (14 feb 2016)
 */
public class DecimalToAnotherBase {
	
	public static void main(String[] args) {
		System.out.println("decimal(27) to base(7): " + solutionI(27, 7));
		System.out.println("decimal(59) to base(7): " + solutionI(59, 7));
		System.out.println("decimal(27) to base(2): " + solutionI(27, 2));
		System.out.println("decimal(69) to base(4): " + solutionI(69, 4));
		System.out.println("decimal(86) to base(9): " + solutionI(86, 9));
	}

	public static String solutionI(int number, int base) {
		StringBuilder result = new StringBuilder();
		int dividend = number;
		int divisor = base;
		int quotient = 0;
		int remainder = 0;

		while(true) {
			remainder = dividend % divisor;
			quotient = dividend / divisor;
			if(quotient >= base) {
				dividend = quotient;
				result.append(remainder);
				continue;			
			}
			else {
				result.append(remainder);
				result.append(quotient);
				break;
			}
		}
		
		return result.reverse().toString();
	}
}