/*
	Circle Class
*/

import java.lang.Math.*;

public class Circle {
	private Point center;
	private double radius;


	/**
	 * no-arg constructor
	 */
	public Circle() {
		center();
		radius = 0;
	}

	/**
	 * Constructor		
	 * @param  valX      The x field of Circle (center X coordinate)
	 * @param  valY      The y field of Circle (center Y coordinate)
	 * @param  valRadius The radius of Circle
	 */
	public Circle(double valX, double valY, double valRadius) {
		x = valX;
		y = valY;
		radius = valRadius;
	/**
	 * The setCenter method store x & y coordinates 
	 * in the center field of Circle
	 * @param p Point object indicating the center coordinates
	 *          of the circle
	 */
	public void setCenter(Point p) {
		center = P;
	}

	/**
	 * The setX method stores a value in the
	 * center X coordinate
	 * @param value The value to store in center.x
	 */
	public void setX(double value) {
		center.setX(value);
	}

	/**
	 * The setY method stores a value in the 
	 * center Y coordinate
	 * @param value The value to store in center.y
	 */
	public void setY(double value) {
		center.setY(value);
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
	 * The getCenter method returns a Point object
	 * with x & y coordinates of the center of the Circle
	 * @return 	Point object with x & y coordinates 
	 *          of the center of the Circle
	 */
	public Point getCenter() {
		return center;
	}


	/**
	 * The getX method returns a Circle
	 * object's x field - (center X coordinate)
	 * @return The value in the x field
	 */
	public double getX() {
		return center.getX();
	}

	/**
	 * The getY method returns a Circle
	 * object's y field - (center Y coordinate)
	 * @return The value in the y field
	 */
	public double getY() {
		return center.getX();
	}
	
	/**
	 * The getRadius returns a Circle
	 * object's radius field
	 * @return The value in the radius field
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * The getArea method returns a MyCicle
	 * objects area
	 * @return The area of a Circle object
	 */
	public double getArea() {
		return Math.PI * radius * radius;
	}

	/**
	 * The doesOverlap method returns true if
	 * this Circle overlaps the passed in
	 * Circle argument
	 * Two circles overlap if the sum of their
	 * radius' is greater than or equal to the
	 * distance between their centers
	 * @param  otherCircle Another Circle
	 * @return             Returns true if the
	 *                     this Circle and the passed in otherCircle
	 *                     overlap, otherwise returns false
	 */
	public boolean doesOverlap(Circle otherCircle) {
		double sumRadii = radius + otherCircle.getRadius();
		double distanceBetweenCenters = Math.sqrt(
			Math.pow((center.getX() - otherCircle.getX()), 2) +
			Math.pow((center.getY() - otherCircle.getY()), 2)
		);

		return sumRadii >= distanceBetweenCenters;
	}
}