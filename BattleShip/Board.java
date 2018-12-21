import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


public class Board {
	
	static final int ROWS = 10;
	static final int COLS = 10;
	
	private Point[][] grid = new Point[ROWS][COLS];
	
	public Board() {
		
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLS; c++) {
				grid[r][c] = new Point(r, c, this);
			}
		}
	}
	
	// Display the grid
	public void display() {
		String cols = "  ";
		
		for (int c = 0; c < COLS; c++) {
			cols += " " + c;
		}
		System.out.println(cols);

		for (int r = 0; r < ROWS; r++) {
			System.out.print(" " + (r));
			for (int c = 0; c < COLS; c++) {
				System.out.print(" " + grid[r][c].displayCharacter());
			}
			
			System.out.println();
		}

	}
	
	// Replace a single point
	public void replacePoint(Point p) {
		grid[p.getY()][p.getX()] = p;
	}	
	
	// Return a single point
	public Point getPoint(int x, int y) {
		return grid[y][x];
	}

	// HELPERS
	/**
	 * Generates a random Point on the board
	 * @param  lowerBound smallest number on the number line (inclusive)
	 * @param  upperBound biggest (exclusive)
	 * @return            Point on the board
	 */
	public Point generateRandomPoint(int lowerBound, int upperBound) {
		int randomRow = ThreadLocalRandom.current().nextInt(lowerBound, upperBound);
		int randomCol = ThreadLocalRandom.current().nextInt(lowerBound, upperBound);
		
		return new Point(randomCol, randomRow, this);
	}
	
	public int generateRandomLength(int lowerBound, int upperBound) {
		return ThreadLocalRandom.current().nextInt(lowerBound, upperBound);
	}

	public boolean generateRandomShipOrientation() {
		int i = ThreadLocalRandom.current().nextInt(0, 2);
		return i > 0 ? true : false;
	}


	public Ship generateRandomShip(int lowerBound, int upperBound, Board gameBoard) {
		// Generate random starting coordinate
		Point origin = generateRandomPoint(lowerBound, upperBound);
		// Generate random ship length
		int shipLength = generateRandomLength(0, 5);
		// Generate random orientation - vertical or horizontal
		boolean isShipVertical = generateRandomShipOrientation();
		// Generate ship based on above
		Ship ship = new Ship(origin, isShipVertical, shipLength, gameBoard);
		
		// Check if ship collides with other ships
			// if collided repeat
			// 
		return ship;
	}



// 	// // Replace a single
// 	// public void replaceCell(AbstractCell cell) {
// 	// 	grid[cell.getRow()][cell.getColumn()] = cell;
// 	// }
	
// 	// Update board
// 	public void advanceToNextGeneration() {
// 		AbstractCell[][] nextGrid = new AbstractCell[ROWS][COLS]; 

// 		// Build the grid for the next generation
// 		for (int r = 0; r < ROWS; r++) {
// 			for (int c = 0; c < COLS; c++) {
// 				nextGrid[r][c] = grid[r][c].cellForNextGeneration();
// 			}
// 		}
		
// 		// Out with the old, in with the new
// 		grid = nextGrid;
// 	}
	
// 	// // Returns true if (r, c) is a valid coordinate, and the cell is alive
// 	// public boolean isAlive(int r, int c) {
// 	// 	return r >= 0 && c >= 0 && r < ROWS && c < COLS && grid[r][c].getIsAlive();
// 	// }
}