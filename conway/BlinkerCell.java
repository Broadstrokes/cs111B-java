public class BlinkerCell extends AbstractCell {
	
	public BlinkerCell(int r, int c, ConwayWorld w) {
		super(r, c, w);
	}
	
	public  AbstractCell cellForNextGeneration() {
		BlinkerCell next = new BlinkerCell(getRow(), getColumn(), world);
		
		next.setIsAlive(willBeAliveInNextGeneration());

		return next;
	}
	
	public boolean willBeAliveInNextGeneration() {
		return (getIsAlive() ? false : true);
	}
	
	public char displayCharacter() {
		return getIsAlive() ? '@' : '.';
	}
}