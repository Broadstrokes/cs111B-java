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