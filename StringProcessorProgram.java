import java.util.Scanner;


public class StringProcessorProgram {
	public static void main(String[] args) {
		println("Starting String Processor Program");
		
		Scanner input = new Scanner(System.in);

		println("Enter a string");
		
		String inputStr = input.nextLine();

		println(inputStr);


		StringProcessor stringToBeProcessed = new StringProcessor(inputStr);
		
		println("total length: " + (stringToBeProcessed.wordCount()));
		println("upperCase length: " + (stringToBeProcessed.uppercaseCount()));

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

}