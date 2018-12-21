import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
	
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {

		

		testShipMethods();


		// // Add some live conway cells, in a horizontal line		
		// for (int i = 0; i < 8; i++) {
		// 	ConwayCell c = new ConwayCell(5, 5 + i, world);
		// 	c.setIsAlive(true);
		// 	world.replaceCell(c);
		// }
		
		// // Add an always-alive cells
		// AbstractCell a = new AlwaysAliveCell(12, 12, world);
		// world.replaceCell(a);
			
		// // Add an always-alive cells
		// AbstractCell n = new NeverAliveCell(17, 17, world);
		// world.replaceCell(n);

		// // Add an Blinker cells
		// BlinkerCell b1 = new BlinkerCell(8, 12, world);
		// world.replaceCell(b1);

		// BlinkerCell b2 = new BlinkerCell(17, 3, world);
		// b2.setIsAlive(true);
		// world.replaceCell(b2);



		// // Add an Custom cells
		// for (int i = 0; i < 8; i++) {
		// 	int randomRow = ThreadLocalRandom.current().nextInt(2, 18);
		// 	int randomCol = ThreadLocalRandom.current().nextInt(2, 18);
		// 	CustomCell c1 = new CustomCell(randomRow, randomCol, world);
		// 	c1.setIsAlive(true);
		// 	world.replaceCell(c1);
		// }

			
		// Go!	
		// do {
		// 	board.display();
		// 	// world.advanceToNextGeneration();
			
		// 	System.out.print("Another? (y/n): ");
		// } while (input.nextLine().charAt(0) == 'y');

	}

	public static void testShipMethods() {
		// Generate a ship
		
		Board gameBoard = new Board();
		
		gameBoard.display();

		Point p1 = new Point(1,1);

		// horizontal
		Ship s1 = new Ship(p1, false, 2, gameBoard);  // (1,1), (2,1), (3,1)


		Point p2 = new Point(4,1);
		// vertical
		Ship s2 = new Ship(p2, true, 2, gameBoard); // (4,1), (4,2), (4,3)


		Point p3 = new Point(4,2);
		Point p4 = new Point(4,5);
		

		Point p5 = new Point(0,0);
		Point p6 = new Point(1,1);
		Point p7 = new Point(2,1);
		Point p8 = new Point(3,1);
		Point p9 = new Point(3,2);


		Point p10 = new Point(4,2);
		Point p11 = new Point(4,3);
		Point p12 = new Point(4,4);
		Point p13 = new Point(3,2);
		Point p14 = new Point(8,8);



		s2.shotFiredAtPoint(p2); // fire
		test(s2.isHitAtPoint(p2) == true, "Passed", "Failed", (p2.toString() + " should be hit ")); // t
		test(gameBoard.getPoint(p2.getX(), p2.getY()).getIsShot() == true, "Passed", "Failed", (p2.toString() + " point on board should be hit ")); // t
		test(gameBoard.getPoint(p2.getX(), p2.getY()).getIsShot() == true, "Passed", "Failed", (p2.toString() + " point on board should be hit ")); // t
		test(gameBoard.getPoint(p2.getX(), p2.getY()).displayCharacter() == 'X', "Passed", "Failed", (p2.toString() + " hit point on board should display 'X' ")); // t

		test(s2.isHitAtPoint(p1) == false, "Passed", "Failed", (p1.toString() + " should not be hit ")); // t
		test(gameBoard.getPoint(p1.getX(), p1.getY()).getIsShot() == false, "Passed", "Failed", (p1.toString() + " point on board should not be hit ")); // t
		test(gameBoard.getPoint(p1.getX(), p1.getY()).displayCharacter() == '~', "Passed", "Failed", (p1.toString() + " hidden point on board should display '~' ")); // t

		s2.shotFiredAtPoint(p14); // fire
		test(s2.isHitAtPoint(p14) == false, "Passed", "Failed", (p14.toString() + " should not be hit ")); // t
		test(gameBoard.getPoint(p14.getX(), p14.getY()).getIsShot() == false, "Passed", "Failed", (p14.toString() + " point on board should not be hit ")); // t
		test(gameBoard.getPoint(p14.getX(), p14.getY()).displayCharacter() == '.', "Passed", "Failed", (p14.toString() + " missed point on board should display '.' ")); // t


		s2.shotFiredAtPoint(p10);
		s2.shotFiredAtPoint(p11);

		s1.shotFiredAtPoint(p1);
		s1.shotFiredAtPoint(p7);
		s1.shotFiredAtPoint(p8);

		gameBoard.display();

		// Board board = new Board();
		// board.display();

				


		// Test if collidesWith function works properly		
		// println(s2.collidesWith(s1)); // f

		// vertical
		// Ship s3 = new Ship(p2, true, 2); // (4,1), (4,2), (4,3)
		// Ship s4 = new Ship(new Point(4,2), true, 3); // (4,2), (4,3), (4,4), (4, 5)
		// println(s2.collidesWith(s3)); // t


		
		
		// Test if containsPoint function works properly




		test(s1.containsPoint(p5) == false, "Passed", "Failed", (s1.getOrigin().toString() + " & " + s1.getEnd().toString() + " should not contain point " + p2.toString())); // t
		test(s1.containsPoint(p6) == true, "Passed", "Failed", (s1.getOrigin().toString() + " & " + s1.getEnd().toString() + " should contain point " + p10.toString())); // t
		test(s1.containsPoint(p7) == true, "Passed", "Failed", (s1.getOrigin().toString() + " & " + s1.getEnd().toString() + " should contain point " + p11.toString())); // t
		test(s1.containsPoint(p8) == true, "Passed", "Failed", (s1.getOrigin().toString() + " & " + s1.getEnd().toString() + " should contain point " + p12.toString())); // f
		test(s1.containsPoint(p9) == false, "Passed", "Failed", (s1.getOrigin().toString() + " & " + s1.getEnd().toString() + " should not contain point " + p4.toString())); // f



		test(s2.containsPoint(p2) == true, "Passed", "Failed", (s2.getOrigin().toString() + " & " + s2.getEnd().toString() + " should contain point " + p2.toString())); // t
		test(s2.containsPoint(p10) == true, "Passed", "Failed", (s2.getOrigin().toString() + " & " + s2.getEnd().toString() + " should contain point " + p10.toString())); // t
		test(s2.containsPoint(p11) == true, "Passed", "Failed", (s2.getOrigin().toString() + " & " + s2.getEnd().toString() + " should contain point " + p11.toString())); // t
		test(s2.containsPoint(p12) == false, "Passed", "Failed", (s2.getOrigin().toString() + " & " + s2.getEnd().toString() + " should not contain point " + p12.toString())); // f
		test(s2.containsPoint(p4) == false, "Passed", "Failed", (s2.getOrigin().toString() + " & " + s2.getEnd().toString() + " should not contain point " + p4.toString())); // f
	}



	/**
	 * Function to test an expectation
	 * @param expression     Expectation/Expression to test, which returns a boolean
	 * @param successMessage String to output to the user if the expectation is met
	 * @param errorMessage   String to output to the user if the expectation is not met
	 * @param should         String stating what should be tested
	 */
	public static void test (boolean expression, String successMessage, String errorMessage, String should) {
		print(should + ": ");

		if (expression)
			println(successMessage);
		else
			println(errorMessage);
	}

  public static void println(Object line) { System.out.println(line); }
	public static void print(Object line) { System.out.print(line); }

}