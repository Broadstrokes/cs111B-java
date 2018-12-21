import java.util.ArrayList;

public class Ship {
	private Point origin;
	private Point end;
	private boolean isVertical;
	private int length;
	private ArrayList<Point> listOfPoints = new ArrayList<Point>();

		//.
	

	/**
	 * This constructor accepts the origin or the ship (its lowest, or
	 * leftmost point), its length, and its orientation (vertical, 
	 * or horizontal)
	 * @param  shipOrigin     [description]
	 * @param  isShipVertical [description]
	 * @param  shipLength     [description]
	 * @return                [description]
	 */
	public Ship(Point shipOrigin, boolean isShipVertical, int shipLength) {
		origin = shipOrigin;
		isVertical = isShipVertical;
		length = shipLength;

		// System.out.println("Created ship of length: " + length + " | is vertical? " + isVertical + " starts at " + origin.toString() + " ends at " + end.toString());
	} 

	// GETTERS
	public Point getOrigin() { return origin; }
	public Point getEnd() { return end; }
	public boolean getIsVertical() { return isVertical; }
	public int getLength() { return length; }

}