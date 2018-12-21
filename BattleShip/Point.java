import java.lang.Math.*;

	public class Point {
	private int x;
	private int y;
	private boolean isShot = false;
	private boolean isMissed = false;
	private boolean shipHasBeenDestroyed = false;
	private int shipLength;
	protected Board board;

	public Point(int xValue, int yValue) {
		x = xValue;
		y = yValue;
	}

	public Point(int xValue, int yValue, Board b) {
		x = xValue;
		y = yValue;
		board = b;
	}

	public Point(Point p) { this(p.x, p.y); }
	// public Point() { this(0, 0); }


	///////////////////////
	// GETTERS & SETTERS //
	///////////////////////

	public void setX(int xValue) { x = xValue; }
	public void setY(int xValue) { y = xValue; }

	public void setIsShot () { isShot = true; }
	public void setIsMissed () { isMissed = true; }
	public void setShipHasBeenDestroyed () { shipHasBeenDestroyed = true; }
	public void setShipLength (int len) { shipLength = len; }


	public int getX() { return x; }
	public int getY() { return y; }


	public boolean getIsShot() { return isShot ;}
	public boolean getIsMissed() { return isMissed ;}

	public boolean getIsRevealed () { return (isShot || isMissed); }


	public boolean equals(Point otherPoint) {
		return (this.x == otherPoint.x) && (this.y == otherPoint.y);
	}
	
	public char displayCharacter() {
		if (shipHasBeenDestroyed) {
			return (char)(shipLength + '0');
		} else {
			if (isShot) { return 'X'; }
			else if (isMissed) { return '.'; }
			else { return '~'; }			
		}
	}
	
	public String toString() { return "(" + x + ", " + y + ")"; }
}