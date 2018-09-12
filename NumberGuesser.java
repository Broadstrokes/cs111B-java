import java.util.Scanner;

public class NumberGuesser {
	public static void main(String[] args) {

		do {

			playOneGame();

		} while (shouldPlayAgain());
	}


	public static void playOneGame() {
		promptUserToGuess();

		int start = 1;
		int end = 100;
		int midpoint;
		char userResponse;

		do {
			midpoint = getMidpoint(start, end);
			userResponse = getUserResponseToGuess(midpoint);
			if (userResponse == 'h') {
				start = midpoint;
			} else if (userResponse == 'l') {
				end = midpoint;
			}
		}
		while (userResponse != 'c');
	}

	public static boolean shouldPlayAgain() {
		Scanner input = new Scanner(System.in);
		System.out.print(
			"Great! Do you want to play again? (y/n): "
		);
		return (input.next().charAt(0) == 'y');
	}



	public static char getUserResponseToGuess(int guess) {
			Scanner input = new Scanner(System.in);
			System.out.print("Is it " + Integer.toString(guess) + "?  (h/l/c): ");
			return input.next().charAt(0);
	}	

	public static void promptUserToGuess() {
			System.out.println("Guess a number between 1 and 100.");
	}

	public static int getMidpoint(int start, int end) {
		return (start + end) / 2;
	}	

}
