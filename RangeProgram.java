import java.util.Scanner;

public class RangeProgram {
	public static void main(String[] args) {
		
		// Create two range objects
		Range r1 = new Range(1, 100);
		Range r2 = new Range(20, 30);

		// Read an integer
		Scanner in = new Scanner(System.in);
		print("Enter a value: ");
		int input = in.nextInt();

		// Check to see if the integer is in r1
		if (r1.contains(input))    
			println("r1 contains " + input);
		else
			println("r1 does not contain " + input);


		// Check to see if r2 is fully inside r1
		if (r1.contains(r2)) 
			println("r1 contains r2");
		else
			println("Range 2 is not inside range 1");

		println("==========================");
		println(" TEST CONSTRUCTOR ");
		println("==========================");
		test(r1.getUpperBound() == 100, "passed", "failed", "set correct upper bound");
		test(r1.getLowerBound() == 1, "passed", "failed", "set correct lower bound");
		test(r2.getUpperBound() == 30, "passed", "failed", "set correct upper bound");
		test(r2.getLowerBound() == 20, "passed", "failed", "set correct lower bound");


		println("==========================");
		println(" TEST GETTERS & SETTERS ");
		println("==========================");

		r1.setUpperBound(15);
		test(r1.getUpperBound() == 15, "passed", "failed", "set correct upper bound");
		r1.setLowerBound(10);
		test(r1.getLowerBound() == 10, "passed", "failed", "set correct lower bound");


		// Check to see if the integer is in r1
		if (r1.contains(input))    
			println("r1 contains " + input);
		else
			println("r1 does not contain " + input);


		// Check to see if r2 is fully inside r1
		if (r1.contains(r2)) 
			println("r1 contains r2");
		else
			println("Range 2 is not inside range 1");


	}


  public static void println(Object line) { System.out.println(line); }
  public static void print(Object line) { System.out.print(line); }

  /**
   * Function to test an expectation
   * @param expression     Expectation/Expression to test, which returns a boolean
   * @param successMessage String to output to the user if the expectation is met
   * @param errorMessage   String to output to the user if the expectation is not met
   * @param should         String stating what should be tested
   */
  public static void test (boolean expression, String successMessage, String errorMessage, String should) {
  	System.out.print(should + ": ");

  	if (expression)
  		System.out.println(successMessage);
  	else
  		System.out.println(errorMessage);
  }

}