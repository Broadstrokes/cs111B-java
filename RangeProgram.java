import java.util.Scanner;

public class RangeProgram {
	public static void main(String[] args) {
		
		// Create two range objects
		Range r1 = new Range(1, 100);
		Range r2 = new Range(20, 30);

		// Read an integer
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a value: ");
		int input = in.nextInt();

		// Check to see if the integer is in r1
		if (r1.contains(input))    
			System.out.println("r1 contains " + input);
		else
			System.out.println("r1 does not contains " + input);


		// Check to see if r2 is fully inside r1
		if (r1.contains(r2)) 
		    System.out.println("r1 contains r2");		 
		else
			System.out.println("Range 2 is not inside range 1");
	}
}