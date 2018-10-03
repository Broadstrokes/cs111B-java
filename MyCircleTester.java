import java.util.ArrayList;


public class MyCircleTester {
	public static void main(String[] args) {

		MyCircle a = new MyCircle(3, 2, 5); // a overlaps with: b, c
		MyCircle b = new MyCircle(-6, 4, 5); // b overlaps with: a, d
		MyCircle c = new MyCircle(11, 2, 4); // c overlaps with: a
		MyCircle d = new MyCircle(-8, -6, 8); // d overlaps with: b

		System.out.println("======TESTING CONSTRUCTOR======");
		MyCircle testCircle = new MyCircle();
		
		test((testCircle.getX() == 0), "Passed", "Failed");
		test((testCircle.getY() == 0), "Passed", "Failed");
		test((testCircle.getRadius() == 0), "Passed", "Failed");

		System.out.println("======TESTING GETTERS & SETTERS======");

		testCircle.setX(5);
		testCircle.setY(10);
		testCircle.setRadius(10);


		test((testCircle.getX() == 5), "Passed", "Failed");
		test((testCircle.getY() == 10), "Passed", "Failed");
		test((testCircle.getRadius() != 0), "Passed", "Failed");
		test((testCircle.getRadius() != Math.PI * Math.pow(testCircle.getRadius(), 2)), "Passed", "Failed");

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


		ArrayList<MyCircle> myCircles = new ArrayList<MyCircle>();
		
		myCircles.add(a); //0
		myCircles.add(b); // overlaps with A
		myCircles.add(c); // overlaps with A
		myCircles.add(d); // overlaps with B


		System.out.println("======RETURN AREA OF EACH CIRCLE======");

		for (MyCircle circle : myCircles) {
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