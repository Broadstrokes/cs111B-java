import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
	
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
	
		// Generate a ship
		
		Point p1 = new Point(1,1);

		// horizontal
		Ship s1 = new Ship(p1, false, 2);  // (1,1), (2,1), (3,1)


		Point p2 = new Point(4,1);
		// vertical
		Ship s2 = new Ship(p2, true, 2); // (4,1), (4,2), (4,3)


		// Board board = new Board();
		// board.display();

				


		// Test if collidesWith function works properly		
		// println(s2.collidesWith(s1)); // f

		// vertical
		// Ship s3 = new Ship(p2, true, 2); // (4,1), (4,2), (4,3)
		// Ship s4 = new Ship(new Point(4,2), true, 3); // (4,2), (4,3), (4,4), (4, 5)
		// println(s2.collidesWith(s3)); // t


		
		
		// Test if containsPoint function works properly

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

		// println(s1.containsPoint(p5)); // f
		// println(s1.containsPoint(p6)); // t
		// println(s1.containsPoint(p7)); // t
		// println(s1.containsPoint(p8)); // t
		// println(s1.containsPoint(p9)); // f


		println(s2.containsPoint(p2)); // t
		println(s2.containsPoint(p10)); // t
		println(s2.containsPoint(p11)); // t
		println(s2.containsPoint(p12)); // f
		println(s2.containsPoint(p4)); // f
		




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

  public static void println(Object line) { System.out.println(line); }
	public static void print(Object line) { System.out.print(line); }

}