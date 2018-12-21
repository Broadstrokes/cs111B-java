import java.lang.Math.*;

	public class Point {
	private int x;
	private int y;
	private boolean isShot = false;
	private boolean isMissed = false;
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

	public void setX(int xValue) { x = xValue; }
	public void setY(int xValue) { y = xValue; }

	public int getX() { return x; }
	public int getY() { return y; }

	public boolean equals(Point otherPoint) {
		return (this.x == otherPoint.x) && (this.y == otherPoint.y);
	}

	public String toString() { return "(" + x + ", " + y + ")"; }
	
	public char displayCharacter() {
		if (isShot) { return 'X'; }
		else if (isMissed) { return '.'; }
		else { return '~'; }
	}

	public boolean isRevealed () { return (isShot || isMissed); }
	// public boolan isShot () { return true ;}
	// public boolan isMissed () { return true ;}
}