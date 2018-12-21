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

		setEnd(origin, isVertical, length);
		addPointsToArray(origin, isVertical, length);

		printAllPointsInListOfPoints();

		// System.out.println("Created ship of length: " + length + " | is vertical? " + isVertical + " starts at " + origin.toString() + " ends at " + end.toString());
	} 

	// GETTERS
	public Point getOrigin() { return origin; }
	public Point getEnd() { return end; }
	public boolean getIsVertical() { return isVertical; }
	public int getLength() { return length; }



	// HELPERS
	
	private void setEnd(Point origin, boolean isVertical, int length) {
		if (isVertical) { // add to Y axis
			end = new Point(origin.getX(), origin.getY() + length);
		} else { // add to X axis
			end = new Point(origin.getX() + length, origin.getY());
		}
	}

	private void addPointsToArray(Point origin, boolean isVertical, int length) {
		if (isVertical) { // check vertically upwards i.e. 'y' axis
			for (int i = 0; i <= length; i++) {
				Point pointToAdd = new Point(origin.getX(), origin.getY() + i);
				listOfPoints.add(pointToAdd);
			}
		} else {
			for (int i = 0; i <= length; i++) {
				Point pointToAdd = new Point(origin.getX() + i, origin.getY());
				listOfPoints.add(pointToAdd);
			}
		}
	}

	public void printAllPointsInListOfPoints() {
		for (int i = 0; i < listOfPoints.size(); i++) {
			System.out.println(listOfPoints.get(i).toString());
		}
	}


}