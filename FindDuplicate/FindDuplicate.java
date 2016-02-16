/* 
 *-The problem-
 *	ACME company is spending too much money in storage drives, for that reason, they would like
 *	to reduce the size of the files processed by the company.
 *	ACME company stores more than 10 Gb of data every day.
 *
 *-Solution-
 *	public static String solutionI(String text)
 *	
 *	Where "String text" is a word with lenght >= 1.
 *
 *	e.g.:
 *	text = "ABBBBCFLL"
 *
 *
 *-My solution-
 *	In this exercise we are using a iterative method.
 *  
 *	We are looking for duplicated chars, if there are more than one consecutive char, it will be replaced by a number of times that it appears plus the char.
 *	Then, we are going from 9 chars to 7 chars.
 *
 *	call#1
 *	"ABBBBCFLL"  --> "A4BCF2L"
 *
 *
 *-author-
 *	Mikel Solabarrieta (01 feb 2016)
 */
public class FindDuplicate {
	
	public static void main(String[] args) {
		System.out.println("ABBBBCFLL --> " + solutionI("ABBBBCFLL"));
		System.out.println("NNNYYRTTT --> " + solutionI("NNNYYRTTT"));
		System.out.println("XII --> " + solutionI("XII"));
		System.out.println("OO --> " + solutionI("OO"));
	}

	public static String solutionI(String text) {
		StringBuilder result = new StringBuilder();

		for(int i = 0; i < text.length();) {
			
			int counter = 1;
			
			for(int x = i + 1; x < text.length() && text.charAt(i) == text.charAt(x); x++, counter++) {
				i = x;
			}

			if(counter > 1) {
				result.append(counter);
			}
			
			result.append(Character.toString(text.charAt(i)));

			i++;
		}

		return result.toString();
	}
}