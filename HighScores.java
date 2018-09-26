import java.util.Scanner;
import java.util.ArrayList;

public class HighScores {


	public static void main(String[] args) {
		final String PROMPT1 = "Enter the name for score #";
		final String PROMPT2 = "Enter the score for score #";
		List<String> names = new ArrayList<>(5);
		List<String> scores = new ArrayList<>(5);

		println(PROMPT1);
	}


	public static void println(Object line) { System.out.println(line); }
	public static void print(Object line) { System.out.print(line); }


	public static void initialize(ArrayList<String> names, ArrayList<Integer> scores) {}
	public static void sort(ArrayList<String> names, ArrayList<Integer> scores) {}
	public static void display(ArrayList<String> names, ArrayList<Integer> scores) {}
}




/*
All of the user input should be done in a method named initialize. It should have the following signature:

public static void initialize(ArrayList<String> names, ArrayList<Integer> scores)

You should write a function that sorts both array lists, based on the values in the scores array list. This is one of the more conceptually challenging parts of the assignment. You want to sort the scores array list, and simultaneously alter the names array list so that the names continue to line up with their respective scores by index. In the example data above, when the score 9900 moves to the first element of the scores array list, the name “Kim” should also be moved to the top of the names array list. The function should have the following signature:

public static void sort(ArrayList<String> names, ArrayList<Integer> scores)

Finally you should write a method that displays the contents of the two arraylists. It should have the following signature:

public static void display(ArrayList<String> names, ArrayList<Integer> scores)

The main method should be very short. It should just declare and initialize the two arraylists and then invoke these three methods.
*/