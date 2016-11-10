import java.util.Scanner;


public class BBall {


	public static int NUM_QUARTERS = 4;
	public static int MAX_QUARTERS = 13;
	public static int quarter = 1;

	public static final int HOME = 1;
	public static final int VISITOR = 2;	
	public static final int DEFAULT = -1;
	public static final String[] QUARTER_PRINT = {"1", "2", "3", "4", "10T", "20T", "30T", "40T", "50T", "60T", "70T", "80T", "90T"};

	public static void initialize (int[] arr1, int[] arr2){
		for(int i = 0; i < MAX_QUARTERS; i++){
			arr1[i] = DEFAULT;
			arr2[i] = DEFAULT;
		}
	}

	public static void readScores(Scanner scores, int[] homeScores, int[] visitorScores){
		int team = HOME;

		while(!gameIsOver(quarter, team, homeScores, visitorScores)){
			if(team == HOME){
				homeScores[quarter-1] = scores.nextInt();
				team = VISITOR;
			}
			if(team == VISITOR){
				visitorScores[quarter-1] = scores.nextInt();
				team = HOME;
			}
			if(team == HOME) quarter++;
		}
		if(quarter > NUM_QUARTERS) quarter--;

	}

	public static int gameScore(int[] teamScore){
		int output = 0;
		for (int i : teamScore)
			if (i != DEFAULT)
				output += i;

		return output;
	}

	public static boolean gameIsOver(int quarter, int team, int[] homeScores, int[] visitorScores){
		int visitorScore = gameScore(visitorScores);
		int homeScore = gameScore(homeScores);

		return (quarter > NUM_QUARTERS && team == HOME && visitorScore != homeScore);
	}



	public static void printBoxScore(int[] homeScores, int[] visitorScores ){
		int i = 0;
		System.out.print("Quarter: ");
		for (int v : visitorScores) {
			if (v != DEFAULT) {
				System.out.print(QUARTER_PRINT[i++] +"\t");
			}else{
				break;
			}
		}

		System.out.println();
		System.out.print("   Home: ");
		for (int v : homeScores) {
			if (v != DEFAULT) {
				System.out.print(v+"\t");		
			}
		}

		System.out.println("");
		System.out.print("Visitor: ");
		for (int v : visitorScores) {
			if (v != DEFAULT) {
				System.out.print(v +"\t");
			}
		}
	}

	public static String result(int[] homeScores, int[] visitorScores){

		int visitorScore = gameScore(visitorScores);
		int homeScore = gameScore(homeScores);

		printBoxScore (homeScores, visitorScores);

		return result(quarter, homeScore, visitorScore);
	}

	public static String result(int quarter, int homeScore, int visitorScore){
		System.out.println("");
		if(visitorScore > homeScore){
			return ("The visiting team won " + visitorScore + " to " + homeScore + " in " + ((quarter == NUM_QUARTERS) ? "Regulation" : ((quarter - NUM_QUARTERS) + " Overtime" + (((quarter -4) == 1) ? "" : "s"))));
		}else if (homeScore > visitorScore){
			return ("The home team won " + homeScore + " to " + visitorScore + " in " + ((quarter == NUM_QUARTERS) ? "Regulation" : ((quarter - NUM_QUARTERS) + " Overtime" + (((quarter -4) == 1) ? "" : "s"))));
		}else{
			return ("The game ended in a tie after " + ((quarter == NUM_QUARTERS) ? "Regulation" : ((quarter - 4) + " Overtimes")));
		}
	}

	public static void main(String[] args) {

		int[] visitorScores = new int[MAX_QUARTERS];
		int[] homeScores = new int[MAX_QUARTERS];

		initialize (homeScores, visitorScores);

		Scanner input = new Scanner(System.in);
		System.out.print("Do you want to see the box scores? (y or n): ");
		String answer = input.next();
		System.out.println("Please enter the scores below:");
		readScores(input, homeScores, visitorScores);

		if(answer.equalsIgnoreCase("y")){
			System.out.println(result(homeScores, visitorScores));
		}else{
			int visitorScore = gameScore(visitorScores);
			int homeScore = gameScore(homeScores);
			System.out.println(result(quarter, homeScore, visitorScore));
		}
	}
}
