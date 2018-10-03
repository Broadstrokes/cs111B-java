import java.util.ArrayList;


public class MyCircleTester {
	public static void main(String[] args) {

		MyCircle a = new MyCircle(3, 2, 5); // a overlaps with: b, c
		MyCircle b = new MyCircle(-6, 4, 5); // b overlaps with: a, d
		MyCircle c = new MyCircle(11, 2, 4); // c overlaps with: a
		MyCircle d = new MyCircle(-8, -6, 8); // d overlaps with: b

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
}