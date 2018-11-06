import java.util.Scanner;


public class StringProcessorProgram {
	public static void main(String[] args) {
		println("Starting String Processor Program");

		Scanner input = new Scanner(System.in);
		boolean playAgain;

		do {
			print("Enter a line of text: ");
			String inputStr = input.nextLine();
			driver(inputStr);
			print("do you want to enter another? (y/n): ");
			playAgain = input.next().charAt(0) == 'y';
			// Consume the remaining newline character.
			input.nextLine();

		} while (playAgain);

		
		/*
			String inputStr = "One for the money, two for the show";
			String inputStr2 = "3 Blind Mice is one of my favorite songs.";
			String inputStr3 = "One for the two, two for the show.";

			driver(inputStr);
			driver(inputStr2);
			driver(inputStr3);
		 */
	}




	/**
	 * Function to test an expectation
	 * @param expression     Expectation/Expression to test, which returns a boolean
	 * @param successMessage What to output to the user if the expectation is met
	 * @param errorMessage   What to output to the user if the expectation is not met
	 */
	public static void test (boolean expression, String successMessage, String errorMessage) {		
		if (expression)
			System.out.println(successMessage);
		else
			System.out.println(errorMessage);
	}

  public static void println(Object line) { System.out.println(line); }
	public static void print(Object line) { System.out.print(line); }

	public static void driver(String inputStr) {
		// println(">>>>>>>>>>>>>>>>>>>");
		// println("TESTING: " + inputStr);
		// println(">>>>>>>>>>>>>>>>>>>");

		StringProcessor stringToBeProcessed = new StringProcessor(inputStr);
		
		println("words: " + (stringToBeProcessed.wordCount()));
		println("uppercase: " + (stringToBeProcessed.uppercaseCount()));
		println("digits: " + (stringToBeProcessed.digitCount()));
		println("digit words: " + (stringToBeProcessed.digitWordCount()));
		println("line with whitespace removed: " + (stringToBeProcessed.getNoSpaceString()));
		println("line with vowels replaced: " + (stringToBeProcessed.getNoVowelString()));
		println("line with digit words replaced: " + (stringToBeProcessed.getNoDigitWordString()));
	}

}