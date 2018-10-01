/*
	MyCircle Class
*/


public class MyCircle {
	private double x,
	private double y,
	private double radius;

	/**
	 * The setX method stores a value in the
	 * x field
	 * @param value The value to store in x
	 */
	public void setX(double value) {
		x = value;
	}

	/**
	 * The setY method stores a value in the 
	 * y field
	 * @param value The value to store in y
	 */
	public void setY(double value) {
		y = value;
	}

	/**
	 * The setRadius method stores a value in the
	 * radius field
	 * @param value The value to store in radius
	 */
	public void setRadius(double value) {
		radius = value;
	}

	/**
	 * The getX method returns a MyCircle
	 * object's x field
	 * @return The value in the x field
	 */
	public double getX() {
		return x;
	}

	/**
	 * The getY method returns a MyCircle
	 * object's y field
	 * @return The value in the y field
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * The getRadius returns a MyCircle
	 * object's radius field
	 * @return The value in the radius field
	 */
	public double getRadius() {
		return radius;
	}
}