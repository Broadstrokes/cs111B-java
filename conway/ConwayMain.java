import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class ConwayMain {
	
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		ConwayWorld world = new ConwayWorld();
		
		// Add some live conway cells, in a horizontal line		
		for (int i = 0; i < 8; i++) {
			ConwayCell c = new ConwayCell(5, 5 + i, world);
			c.setIsAlive(true);
			world.replaceCell(c);
		}
		
		// Add an always-alive cells
		AbstractCell a = new AlwaysAliveCell(12, 12, world);
		world.replaceCell(a);
			
		// Add an always-alive cells
		AbstractCell n = new NeverAliveCell(17, 17, world);
		world.replaceCell(n);

		// Add an Blinker cells
		BlinkerCell b1 = new BlinkerCell(8, 12, world);
		world.replaceCell(b1);

		BlinkerCell b2 = new BlinkerCell(17, 3, world);
		b2.setIsAlive(true);
		world.replaceCell(b2);



		// Add an Custom cells
		for (int i = 0; i < 8; i++) {
			int randomRow = ThreadLocalRandom.current().nextInt(2, 18);
			int randomCol = ThreadLocalRandom.current().nextInt(2, 18);
			CustomCell c1 = new CustomCell(randomRow, randomCol, world);
			c1.setIsAlive(true);
			world.replaceCell(c1);
		}

			
		// Go!	
		do {
			world.display();
			world.advanceToNextGeneration();
			
			System.out.print("Another? (y/n): ");
		} while (input.nextLine().charAt(0) == 'y');
	}
}