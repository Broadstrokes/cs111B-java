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

	/////////////
	// GETTERS //
	/////////////
	public Point getOrigin() { return origin; }
	public Point getEnd() { return end; }
	public boolean getIsVertical() { return isVertical; }
	public int getLength() { return length; }






	// Returns true if a Ship covers a point on the board, false if it does not.
	public boolean containsPoint(Point pointToCheck) {

		for (int i = 0; i < listOfPoints.size(); i++) {
			Point currentPoint = listOfPoints.get(i);
			if (currentPoint.equals(pointToCheck)) return true;
		}

		return false;
	}

	// Returns true if the receiving ship shares a point with the argument ship. Collides with it, so to speak.
	public boolean collidesWith(Ship s) {
		Point sOrigin = s.getOrigin();
		if (s.getIsVertical()) { // check vertically upwards i.e. 'y' axis
			for (int i = 0; i <= s.getLength(); i++) {

				Point pointToCheck = new Point(sOrigin.getX(), sOrigin.getY() + i);
				if(this.containsPoint(pointToCheck)) return true;
			}
		} else {
			for (int i = 0; i <= s.getLength(); i++) {
				Point pointToCheck = new Point(sOrigin.getX() + i, sOrigin.getY());
				if(this.containsPoint(pointToCheck)) return true;
			}
		}

		return false;
	}

	// //- This is a verb in the game. When the user enters a coordinate, this method can be called on each ship. If the ship contains the point, it should remember that it has been hit at that point. It could do this with a second PointCollection, or some other data strategy.
	// public void shotFiredAtPoint(Point p) {
	// 	this.containsPoint(p);
	// }

	// // - returns true if shotFiredAtPoint has been called for this point in the ship. False if it has not, or if the point is not in the ship.
	// public boolean isHitAtPoint(Point p) {

	// }

	// //- returns the number of points in the ship that have been hit. When the hitCount is equal to the length of the ship the ship is considered to be sunk.
	// public int hitCount() {

	// }




	/////////////
	// HELPERS //
	/////////////

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