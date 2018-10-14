import java.util.ArrayList;
import java.lang.Math.*;

public class CircleProgram {
	public static void main(String[] args) {

		Circle a = new Circle(3, 2, 5); // a overlaps with: b, c
		Circle b = new Circle(-6, 4, 5); // b overlaps with: a, d
		Circle c = new Circle(11, 2, 4); // c overlaps with: a
		Circle d = new Circle(-8, -6, 8); // d overlaps with: b

		System.out.println("================================");
		System.out.println("======TESTING CONSTRUCTORS======");
		System.out.println("================================");

		System.out.println("====== CONSTRUCTOR w/ no-args ======");
		Circle testCircle1 = new Circle();
		
		test((testCircle1.getX() == 0), "Passed", "Failed");
		test((testCircle1.getY() == 0), "Passed", "Failed");
		test((testCircle1.getRadius() == 0), "Passed", "Failed");


		System.out.println("====== CONSTRUCTOR w/ Point ======");
		Point p = new Point(3, 2);
		Circle testCircle2 = new Circle (p, 10);
		test((testCircle2.getX() == 3), "Passed", "Failed");
		test((testCircle2.getY() == 2), "Passed", "Failed");
		test((testCircle2.getRadius() == 10), "Passed", "Failed");
		test((testCircle2.getArea() == Math.PI * 10 * 10), "Passed", "Failed");


		System.out.println("====== CONSTRUCTOR w/ x, y, & r ======");
		Circle testCircle3 = new Circle (3, 2, 10);
		test((testCircle3.getX() == 3), "Passed", "Failed");
		test((testCircle3.getY() == 2), "Passed", "Failed");
		test((testCircle3.getRadius() == 10), "Passed", "Failed");
		test((testCircle3.getArea() == Math.PI * 10 * 10), "Passed", "Failed");



		System.out.println("====== CONSTRUCTOR w/ Circle Object ======");
		Circle testCircle4 = new Circle(b);
		test((testCircle4.getX() == -6), "Passed", "Failed");
		test((testCircle4.getY() == 4), "Passed", "Failed");
		test((testCircle4.getRadius() == 5), "Passed", "Failed");
		test((testCircle4.getArea() == Math.PI * 5 * 5), "Passed", "Failed");



		System.out.println("======TESTING GETTERS & SETTERS======");

		testCircle1.setX(5);
		testCircle1.setY(10);
		testCircle1.setRadius(10);


		test((testCircle1.getX() == 5), "Passed", "Failed");
		test((testCircle1.getY() == 10), "Passed", "Failed");
		test((testCircle1.getRadius() != 0), "Passed", "Failed");
		test((testCircle1.getRadius() != Math.PI * Math.pow(testCircle1.getRadius(), 2)), "Passed", "Failed");

		System.out.println("======TESTING OVERLAP======");
		test((a.doesOverlap(b) == true), "Passed", "Failed");
		test((a.doesOverlap(c) == true), "Passed", "Failed");
		test((b.doesOverlap(a) == true), "Passed", "Failed");
		test((c.doesOverlap(a) == true), "Passed", "Failed");
		test((d.doesOverlap(b) == true), "Passed", "Failed");
		test((b.doesOverlap(d) == true), "Passed", "Failed");
		
		System.out.println("======TESTING NO OVERLAP======");
		test((a.doesOverlap(d) == false), "Passed", "Failed");
		test((b.doesOverlap(c) == false), "Passed", "Failed");
		test((c.doesOverlap(b) == false), "Passed", "Failed");
		test((c.doesOverlap(d) == false), "Passed", "Failed");
		test((d.doesOverlap(a) == false), "Passed", "Failed");
		test((d.doesOverlap(c) == false), "Passed", "Failed");


		ArrayList<Circle> myCircles = new ArrayList<Circle>();
		
		myCircles.add(a); //0
		myCircles.add(b); // overlaps with A
		myCircles.add(c); // overlaps with A
		myCircles.add(d); // overlaps with B


		System.out.println("======RETURN AREA OF EACH CIRCLE======");

		for (Circle circle : myCircles) {
			System.out.println(circle.getArea());
		}

	}


	/**
	 * Function to test an expectation
	 * @param expression     Expectation/Expression to test, which returns a boolean
	 * @param successMessage What to output to the user if the expectation is met
	 * @param errorMessage   What to output to the user if the expectation is not met
	 */
	public static void test (boolean expression, String successMessage, String errorMessage) {		
		if (expression)
			System.out.println(successMessage);
		else
			System.out.println(errorMessage);
	}
}