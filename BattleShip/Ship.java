import java.util.ArrayList;

public class Ship {
	private Point origin;
	private Point end;
	private boolean isVertical = false;
	private int length;
	private int hitCount;
	private boolean shipHasBeenDestroyed = false;
	private ArrayList<Point> listOfPoints = new ArrayList<Point>();
	private ArrayList<Point> pointsHit = new ArrayList<Point>();
	protected Board gameBoard;

	/**
	 * This constructor accepts the origin or the ship (its lowest, or
	 * leftmost point), its length, and its orientation (vertical, 
	 * or horizontal)
	 * @param  shipOrigin     [description]
	 * @param  isShipVertical [description]
	 * @param  shipLength     [description]
	 * @return                [description]
	 */
	public Ship(Point shipOrigin, boolean isShipVertical, int shipLength, Board b) {
		origin = shipOrigin;
		isVertical = isShipVertical;
		length = shipLength;
		gameBoard = b;

		setEnd(origin, isVertical, length);
		addPointsToArray(origin, isVertical, length);

		printShipCoordinates();

		// System.out.println("Created ship of length: " + length + " | is vertical? " + isVertical + " starts at " + origin.toString() + " ends at " + end.toString());
	} 

	/////////////
	// GETTERS //
	/////////////

	public Point getOrigin() { return origin; }
	public Point getEnd() { return end; }
	public boolean getIsVertical() { return isVertical; }
	public int getLength() { return length; }



	/**
	 * Returns true if a Ship covers a point on the board, false if it does not.
	 * @param  pointToCheck [description]
	 * @return              [description]
	 */
	public boolean containsPoint(Point pointToCheck) {

		for (int i = 0; i < listOfPoints.size(); i++) {
			Point currentPoint = listOfPoints.get(i);
			if (currentPoint.equals(pointToCheck)) return true;
		}

		return false;
	}

	// 
	/**
	 * Returns true if the receiving ship shares a point with the argument ship. 
	 * Collides with it, so to speak.
	 * @param  s [description]
	 * @return   [description]
	 */
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

	//- This is a verb in the game. When the user enters a coordinate, this method can be called on each ship. If the ship contains the point, it should remember that it has been hit at that point. It could do this with a second PointCollection, or some other data strategy.
	public void shotFiredAtPoint(Point p) {
		if (this.containsPoint(p)) {
			if (!p.getIsShot()) {
				pointsHit.add(p);
				p.setIsShot();
				hitCount++;
				gameBoard.replacePoint(p);
			}

			if (hitCount == length + 1) {
				shipHasBeenDestroyed = true;

				for (int i = 0; i < listOfPoints.size(); i++) {
					System.out.println("<>>>>>>");
					Point currentPoint = listOfPoints.get(i);
					currentPoint.setShipLength(length);
					currentPoint.setShipHasBeenDestroyed();
					gameBoard.replacePoint(currentPoint);
				}
			}
		} else {
			p.setIsMissed();
			gameBoard.replacePoint(p);
		}
	}
 
	/**
	 * Returns true if shotFiredAtPoint has been called for this point in the ship.
	 * False if it has not, or if the point is not in the ship.
	 * @param  p [description]
	 * @return   [description]
	 */
	public boolean isHitAtPoint(Point p) {
		for (int i = 0; i < pointsHit.size(); i++) {
			Point currentPoint = pointsHit.get(i);
			if (currentPoint.equals(p)) return true;
		}

		return false;
	}

	/**
	 * Returns the number of points in the ship that have been hit. 
	 * When the hitCount is equal to the length of the ship the ship is considered to be sunk.
	 * @return int number of coordinates hit on the ship
	 */
	public int hitCount() { return hitCount; }



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

	public void printShipCoordinates() {
		String output = "Ship coordinates:";
		for (int i = 0; i < listOfPoints.size(); i++) {
			output += " " + listOfPoints.get(i).toString();
		}
		System.out.println(output);
	}


}