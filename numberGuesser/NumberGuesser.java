/*
	NumberGuesser Class
*/

public class NumberGuesser {
	private int originalUpper;
	private int originalLower;
	private int upper;
	private int lower;

	/**
	 * Constructor
	 * @param  lowerBound The lower & originalLower field of NumberGuesser
	 * @param  upperBound The upper & originalUppwer field of NumberGuesser
	 */
	public NumberGuesser(int lowerBound, int upperBound) {
		upper = upperBound; 
		lower = lowerBound;
		originalUpper = upperBound; 
		originalLower = lowerBound;
	}

	/**
	 * Get the current guess
	 * @return the current guess
	 */
	public int getCurrentGuess() {
		return ((upper + lower) / 2);
	}

	/**
	 * Updates the lower property
	 */
	public void higher() {
		lower = getCurrentGuess() + 1;
	}

	/**
	 * Updates the upper property
	 */
	public void lower() {
		upper = getCurrentGuess();
	}

	/**
	 * Resets to the original bounds
	 */
	public void reset() {
		upper = originalUpper;
		lower = originalLower;
	}
}
