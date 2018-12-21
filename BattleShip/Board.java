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
		for (int r = 0; r < ROWS; r++) {
			System.out.print(" " + (ROWS - r - 1));
			for (int c = 0; c < COLS; c++) {
				System.out.print(" " + grid[r][c].displayCharacter());
				if(r == 0) { cols += " " + c; }
			}
			
			System.out.println();
		}
		System.out.println(cols);

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