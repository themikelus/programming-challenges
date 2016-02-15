import java.util.Arrays;

/* 
 *-The problem-
 *	ACME company has a small office in Caracas, Venezuela. 
 *	The office has limited rooms/desks, and the manager needs to assign one office to every team.
 *	The teams cannot be separated, all team members must be working together in the same room.
 *	You can move desks from a room to another without problems. 
 *
 *-Solution-
 *	public static boolean solutionR(int[] desk, int[] team)
 *	
 *	Where "int[] desk" is an array with length > 0, with non-zero values.
 *	Where "int[] team" is an array with length > 0, with non-zero values.
 *
 *	e.g.:
 *	desk = [2,4,1] (in this case we have 3 rooms, and we have a total of 7 desks)
 *	team = [3,2,2] (in this case we have 3 teams
 *					first team with 3 people
 *					second team with 2 people
 *					third team with 2 people)
 *
 *-My solution-
 *	In this exercise we are using a recursive method.
 *
 *	call#1
 *	Desk[2, 4, 1]  Team[3, 2, 2]  
 *	
 *		Call#2
 *		Desk[3, 3, 1]  Team[3, 2, 2] <-- moving one desk
 *	
 *			Call#3 
 *			Desk[3, 1]  Team[2, 2] 
 *	
 *				Call#4
 *				Desk[1, 1]  Team[2] 
 *	
 *					Call#5
 *					Desk[2]  Team[2] 
 *	
 *						Call#6
 *						Desk[]  Team[] <-- stop criteria
 *	
 *	True, the office has enough space for us!
 *
 *
 *-author-
 *	Mikel Solabarrieta (15 feb 2016)
 */
public class DesksAndTeams {
	
	public static void main(String[] args) {
		System.out.println("*First test: " + solutionR(new int[] {2, 4, 1}, new int[] {3, 2, 2}) + "\n");
		System.out.println("*Second test: " + solutionR(new int[] {2, 4}, new int[] {3, 2, 2}) + "\n");
		System.out.println("*Third test: " + solutionR(new int[] {1}, new int[] {2}) + "\n");
		System.out.println("*Fourth test: " + solutionR(new int[] {3, 4, 5}, new int[] {1}) + "\n");
		System.out.println("*Fifth test: " + solutionR(new int[] {1}, new int[] {2, 3}) + "\n");
	}

	public static boolean solutionR(int[] desk, int[] team) {
		System.out.print("Desk" + Arrays.toString(desk) + " ");
		System.out.println("Team" + Arrays.toString(team) + " ");

		if(team.length == 0) {
			return true;
		}
		else if(desk.length == 0) {
			return false;
		}

		while(true) {
			int i = 0;

			if(team[i] == desk[i]) {
				desk = Arrays.copyOfRange(desk, i + 1, desk.length);
				team = Arrays.copyOfRange(team, i + 1, team.length);
			}
			else if(desk[i] > team[i]) {
				desk[i] = desk[i] - team[i];
				team = Arrays.copyOfRange(team, i, team.length - 1);
			}
			else {
				if(i + 1 < desk.length) {
					desk[i] = desk[i] + 1;
					desk[i + 1] = desk[i + 1] - 1;					

					if(desk[i + 1] == 0) {
						desk = Arrays.copyOfRange(desk, i, desk.length - 1);
					}
				}
				else {
					return false;
				}
			}

			return solutionR(desk, team);
		}
	}
}