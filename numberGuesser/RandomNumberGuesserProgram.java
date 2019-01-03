import java.util.Scanner;

public class RandomNumberGuesserProgram {
	public static void main(String[] args) {
		
		RandomNumberGuesser game1 = new RandomNumberGuesser(1, 10);
		
		do {
			playOneGame(game1);
		} while (shouldPlayAgain());
	}


	/**
	 * Starts the game and continues playing until user wants to end
	 * @param gameInstance instance of NumberGuesser
	 */
	public static void playOneGame(NumberGuesser gameInstance) {
		char userResponse;
		int guess;

		promptUserToChooseNumber();
		
		do {
			guess = gameInstance.getCurrentGuess();
			userResponse = getUserResponseToGuess(guess);
			if (userResponse == 'h') {
				gameInstance.higher();
			} else if (userResponse == 'l') {
				gameInstance.lower();
			}
		} 
		while (userResponse != 'c');

		gameInstance.reset();
	}


	/**
	 * Prompt user to play again or not
	 * @return boolean true indicates the user wants to play again
	 */
	public static boolean shouldPlayAgain() {
		Scanner input = new Scanner(System.in);
		System.out.print(
			"Great! Do you want to play again? (y/n): "
		);

		return (input.next().charAt(0) == 'y');
	}


	/**
	 * Prompts user with a guess
	 * @param  guess Integer guess to be presented to the user
	 * @return       'h', 'l', 'c' indicating the guess is higher, lower or correct
	 */
	public static char getUserResponseToGuess(int guess) {
			Scanner input = new Scanner(System.in);
			System.out.print("Is it " + Integer.toString(guess) + "?  (h/l/c): ");
			return input.next().charAt(0);
	}	


	/**
	 * Prompt the user to guess
	 */
	public static void promptUserToChooseNumber() {
			System.out.println("Think of a number between 1 and 100");
	}
}