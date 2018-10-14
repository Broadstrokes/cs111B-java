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
		
		test((testCircle1.getX() == 0), "Passed", "Failed", "should get x coordiante");
		test((testCircle1.getY() == 0), "Passed", "Failed", "should get y coordiante");
		test((testCircle1.getRadius() == 0), "Passed", "Failed", "should get radius");
		System.out.println(testCircle1.toString());

		System.out.println("====== CONSTRUCTOR w/ Point ======");
		Point p = new Point(3, 2);
		Circle testCircle2 = new Circle(p, 10);
		test((testCircle2.getX() == 3), "Passed", "Failed", "should get x coordiante");
		test((testCircle2.getY() == 2), "Passed", "Failed", "should get y coordiante");
		test((testCircle2.getRadius() == 10), "Passed", "Failed", "should get radius");
		test((testCircle2.getArea() == Math.PI * 10 * 10), "Passed", "Failed", "should get area");
		System.out.println(testCircle2.toString());

		System.out.println("====== CONSTRUCTOR w/ x, y, & r ======");
		Circle testCircle3 = new Circle(3, 2, 10);
		test((testCircle3.getX() == 3), "Passed", "Failed", "should get x coordiante");
		test((testCircle3.getY() == 2), "Passed", "Failed", "should get y coordiante");
		test((testCircle3.getRadius() == 10), "Passed", "Failed", "should get radius");
		test((testCircle3.getArea() == Math.PI * 10 * 10), "Passed", "Failed", "should get area");
		System.out.println(testCircle3.toString());


		System.out.println("====== CONSTRUCTOR w/ Circle Object ======");
		Circle testCircle4 = new Circle(b);
		test((testCircle4.getX() == -6), "Passed", "Failed", "should get x coordiante");
		test((testCircle4.getY() == 4), "Passed", "Failed", "should get y coordiante");
		test((testCircle4.getRadius() == 5), "Passed", "Failed", "should get radius");
		test((testCircle4.getArea() == Math.PI * 5 * 5), "Passed", "Failed", "should get area");
		System.out.println(testCircle4.toString());

		System.out.println("=====================================");
		System.out.println("======TESTING GETTERS & SETTERS======");
		System.out.println("=====================================");

		testCircle1.setX(5);
		testCircle1.setY(10);
		testCircle1.setRadius(10);


		test((testCircle1.getX() == 5), "Passed", "Failed", "should get updated x coordiante");
		test((testCircle1.getY() == 10), "Passed", "Failed", "should get updated y coordiante");
		test((testCircle1.getRadius() != 0), "Passed", "Failed", "should get new radius");

		System.out.println("===================================================");
		System.out.println("======TESTING IF 2 Circles have same x, y, r ======");
		System.out.println("===================================================");
		Circle testCircle5 = new Circle(4, 5, 10);
		Circle testCircle6 = new Circle(4, 5, 10);
		Circle testCircle7 = new Circle(4, 3, 10);
			
		test((testCircle5.equals(testCircle6)), "Passed", "Failed", "should indicate testCircle5 equals testCircle6");
		test((testCircle5.equals(testCircle7) == false), "Passed", "Failed", "should indicate testCircle5 doesn't equal testCircle7");

		System.out.println("================================");
		System.out.println("======TESTING OVERLAP===========");
		System.out.println("================================");
		test((a.doesOverlap(b) == true), "Passed", "Failed", "should indicate Circle a overlaps Circle b");
		test((a.doesOverlap(c) == true), "Passed", "Failed", "should indicate Circle a overlaps Circle c");
		test((b.doesOverlap(a) == true), "Passed", "Failed", "should indicate Circle b overlaps Circle a");
		test((c.doesOverlap(a) == true), "Passed", "Failed", "should indicate Circle c overlaps Circle a");
		test((d.doesOverlap(b) == true), "Passed", "Failed", "should indicate Circle d overlaps Circle b");
		test((b.doesOverlap(d) == true), "Passed", "Failed", "should indicate Circle b overlaps Circle d");
		
		System.out.println("================================");
		System.out.println("======TESTING NO OVERLAP========");
		System.out.println("================================");
		test((a.doesOverlap(d) == false), "Passed", "Failed", "should indicate Circle a doesn't overlap Circle d");
		test((b.doesOverlap(c) == false), "Passed", "Failed", "should indicate Circle b doesn't overlap Circle c");
		test((c.doesOverlap(b) == false), "Passed", "Failed", "should indicate Circle c doesn't overlap Circle b");
		test((c.doesOverlap(d) == false), "Passed", "Failed", "should indicate Circle c doesn't overlap Circle d");
		test((d.doesOverlap(a) == false), "Passed", "Failed", "should indicate Circle d doesn't overlap Circle a");
		test((d.doesOverlap(c) == false), "Passed", "Failed", "should indicate Circle c doesn't overlap Circle c");


		ArrayList<Circle> myCircles = new ArrayList<Circle>();
		
		myCircles.add(a); //0
		myCircles.add(b); // overlaps with A
		myCircles.add(c); // overlaps with A
		myCircles.add(d); // overlaps with B

		System.out.println("============================================");
		System.out.println("======CALCULATE AREA OF A GIVEN CIRCLE======");
		System.out.println("============================================");

		for (Circle circle : myCircles) {
			// toString utilizes the getArea method
			System.out.println(circle.toString());
		}
	}


	/**
	 * Function to test an expectation
	 * @param expression     Expectation/Expression to test, which returns a boolean
	 * @param successMessage What to output to the user if the expectation is met
	 * @param errorMessage   What to output to the user if the expectation is not met
	 */
	public static void test (boolean expression, String successMessage, String errorMessage, String should) {
		System.out.print(should + ": ");

		if (expression)
			System.out.println(successMessage);
		else
			System.out.println(errorMessage);
	}
}