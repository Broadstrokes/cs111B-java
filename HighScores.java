import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class HighScores {


	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<>(5);
		ArrayList<Integer> scores = new ArrayList<>(5);

		initialize(names, scores);
		sort(names, scores);
	}


	public static void println(Object line) { System.out.println(line); }
	public static void print(Object line) { System.out.print(line); }
	public static void initialize(ArrayList<String> names, ArrayList<Integer> scores) {
	    Scanner input = new Scanner(System.in);
	    int size = 5;
			int count = 0;
	    final String PROMPT1 = "Enter the name for score #";
	    final String PROMPT2 = "Enter the score for score #";

			while(count < size) {
				count++;
				
				print(PROMPT1 + count + ": ");
				names.add(input.next());
				print(PROMPT2 + count + ": ");
				scores.add(input.nextInt());
			}	
	}

	public static void sort(ArrayList<String> names, ArrayList<Integer> scores) {
		int indexToSwap;
		int size = scores.size();

		for (int i = 0; i < size; i++) {
		    indexToSwap = findIndexOfLargest(scores, i, size);
		    Collections.swap(scores, i, indexToSwap);
		    Collections.swap(names, i, indexToSwap);
		}
	}

	public static void initialize(ArrayList<String> names, ArrayList<Integer> scores) {}
	public static void sort(ArrayList<String> names, ArrayList<Integer> scores) {}
	public static void display(ArrayList<String> names, ArrayList<Integer> scores) {}
		////////////////////
		// HELPER METHODS //
		////////////////////

	/*
		Helper method for sort
	 */
	public static int findIndexOfLargest(ArrayList<Integer> scores, int startingIndex, int numItems) {
	    int indexOfLargest = startingIndex;
	    
	    for (int i = startingIndex + 1; i < numItems; i++) {
	        if (scores.get(i) > scores.get(indexOfLargest)) {
	            indexOfLargest = i;
	        }
	    }
	    
	    return indexOfLargest;
	}
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