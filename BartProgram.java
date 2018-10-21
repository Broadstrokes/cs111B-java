public class BartProgram {
	public static void main(String[] arg) {
		println("========= Bart Program ==========");

		BARTTrain train1 = new BARTTrain();


		println("==========================");
		println(" TEST NO ARG CONSTRUCTOR ");
		println("==========================");
		test(train1.getNextStation() == "", "passed", "failed", "set and get empty station");
		test(train1.getMinutesToNextStation() == 0, "passed", "failed", "get 0 as time to next station");


		println("==========================");
		println(" TEST ARG CONSTRUCTOR ");
		println("==========================");
		
		BARTTrain train2 = new BARTTrain("Montgomery", 5.0, 15.0, true);

		test(train2.getNextStation() == "Montgomery", "passed", "failed", "set next station");
		test(train2.getMinutesToNextStation() == 3, "passed", "failed", "get correct time to next station");
		test(train2.getMinutesToNextStation() != 5, "passed", "failed", "get correct time to next station");


		println("==========================");
		println(" TEST Equal Method ");
		println("==========================");

		BARTTrain train3 = new BARTTrain("Montgomery", 5.0, 15.0, true);
		BARTTrain train4 = new BARTTrain("Montgomery", 5.0, 15.0, true);
		BARTTrain train5 = new BARTTrain("Powell", 5.0, 15.0, true);
		BARTTrain train6 = new BARTTrain("Montgomery", 5.0, 25.0, true);
		BARTTrain train7 = new BARTTrain("Fruitvale", 5.5, 25.0, false);

		test(train3.equals(train4) == true, "passed", "failed", "identify same train");
		test(train2.equals(train4) == true, "passed", "failed", "identify same train");
		test(train5.equals(train4) == false, "passed", "failed", "identify not same train");
		test(train6.equals(train4) == false, "passed", "failed", "identify not same train");

		println("==========================");
		println(" TEST toString Method ");
		println("==========================");

		println(train1.toString());
		println(train2.toString());
		println(train3.toString());
		println(train4.toString());
		println(train5.toString());
		println(train6.toString());
		println(train7.toString());

	}

	public static void println(Object line) { System.out.println(line); }
	public static void print(Object line) { System.out.print(line); }

	/**
	 * Function to test an expectation
	 * @param expression     Expectation/Expression to test, which returns a boolean
	 * @param successMessage String to output to the user if the expectation is met
	 * @param errorMessage   String to output to the user if the expectation is not met
	 * @param should         String stating what should be tested
	 */
	public static void test (boolean expression, String successMessage, String errorMessage, String should) {
		System.out.print(should + ": ");

		if (expression)
			System.out.println(successMessage);
		else
			System.out.println(errorMessage);
	}	
}