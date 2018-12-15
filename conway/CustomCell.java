public class CustomCell extends AbstractCell {
	
	public CustomCell(int r, int c, ConwayWorld w) {
		super(r, c, w);
	}
	
	public boolean willBeAliveInNextGeneration() {
		int row = getRow();
		int column = getColumn();
		
		return !(
			world.isAlive(row, column + 1) || 
			world.isAlive(row, column - 1) || 
			world.isAlive(row + 1, column) ||
			world.isAlive(row - 1, column)
		);
	}
	
	public AbstractCell cellForNextGeneration() {
		CustomCell next = new CustomCell(getRow(), getColumn(), world);
		
		next.setIsAlive(willBeAliveInNextGeneration());

		return next;
	}

	public char displayCharacter() {
		return getIsAlive() ? '#' : '.';
	}
}