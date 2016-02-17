/* 
 *-The problem-
 *	ACME company wants to invest money in the USA stock market.
 *	They would like to buy shares low and sell high. 
 *
 *-Solution-
 *	public static int solutionI(int[] priceShare)
 *	
 *	Where "int[] priceShare" will be an int array with length == 5, non-zero values.
 *	This array has length = 5, because each position is a week day (monday to friday)
 *	Each position mean a stock price.	
 *
 *	e.g.:
 *	priceShare = [10, 3, 4, 6, 9]
 *	monday = 10$
 *	tuesday = 3$
 *	wednesday = 4$
 *	thursday = 6$
 *	friday = 9$
 *
 *-My solution-
 *	In this exercise we are using a iterative method.
 *	This solution will find the best day to buy and the best day to sell.
 *
 *	call#1
 *	priceShare = [10, 3, 4, 6, 9]
 *	lowerPrice = 3 (buying tuesday)
 *	higherPrice = 9 (selling friday)	  
 *	profit = 6
 *
 *-author-
 *	Mikel Solabarrieta (07 feb 2016)
 */
public class SmartStockTrading {
	
	public static void main(String[] args) {
		System.out.println(solutionI(new int[] {10, 3, 4, 6, 9}));
		System.out.println(solutionI(new int[] {2, 3, 19, 6, 20}));
		System.out.println(solutionI(new int[] {4, 1, 2, 1, 1}));
		System.out.println(solutionI(new int[] {2, 1, 1, 1, 1}));
	}

	public static int solutionI(int[] priceShare) {
		int lowerPrice = 0;
		int higherPrice = 0;

		for(int i = 0; i < priceShare.length; i++) {
			if(lowerPrice == 0) {
				lowerPrice = priceShare[i];
				higherPrice = priceShare[i];
			}
			
			if(priceShare[i] < lowerPrice) {
				lowerPrice = priceShare[i];
				higherPrice = priceShare[i];
			}
			
			if(priceShare[i] > higherPrice) {
				higherPrice = priceShare[i];
			}
		}

		return higherPrice - lowerPrice; // profit
	}
}