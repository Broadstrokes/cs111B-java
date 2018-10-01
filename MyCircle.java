/*
	MyCircle Class
*/

import java.lang.Math.*;

public class MyCircle {
	private double x;
	private double y;
	private double radius;


	/**
	 * no-arg constructor
	 */
	public MyCircle() {
		x = 0;
		y = 0;
		radius = 0;
	}

	/**
	 * Constructor		
	 * @param  valX      The x field of MyCircle (center X coordinate)
	 * @param  valY      The y field of MyCircle (center Y coordinate)
	 * @param  valRadius The radius of MyCircle
	 */
	public MyCircle(double valX, double valY, double valRadius) {
		x = valX;
		y = valY;
		radius = valRadius;
	}

	/**
	 * The setX method stores a value in the
	 * x field - (center X coordinate)
	 * @param value The value to store in x
	 */
	public void setX(double value) {
		x = value;
	}

	/**
	 * The setY method stores a value in the 
	 * y field - (center Y coordinate)
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
	 * object's x field - (center X coordinate)
	 * @return The value in the x field
	 */
	public double getX() {
		return x;
	}

	/**
	 * The getY method returns a MyCircle
	 * object's y field - (center Y coordinate)
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

	/**
	 * The getArea method returns a MyCicle
	 * objects area
	 * @return The area of a MyCircle object
	 */
	public double getArea() {
		return Math.PI * radius * radius;
	}

	/**
	 * The doesOverlap method returns true if
	 * this MyCircle overlaps the passed in
	 * MyCircle argument
	 * Two circles overlap if the sum of their
	 * radius' is greater than or equal to the
	 * distance between their centers
	 * @param  otherCircle Another MyCircle
	 * @return             Returns true if the
	 *                     this MyCircle and the passed in otherCircle
	 *                     overlap, otherwise returns false
	 */
	public boolean doesOverlap(MyCircle otherCircle) {
		double sumRadii = radius + otherCircle.getRadius();
		double distanceBetweenCenters = Math.sqrt(
			Math.pow((x - otherCircle.getX()), 2) +
			Math.pow((y - otherCircle.getY()), 2)
		);

		return sumRadii >= distanceBetweenCenters;
	}
}