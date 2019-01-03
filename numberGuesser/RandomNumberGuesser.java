public class RandomNumberGuesser extends NumberGuesser {
	private int currentGuess;
	private boolean firstCall = true;

	/**
	 * Constructor
	 * @param  lowerBound The lower & originalLower field of NumberGuesser superclass
	 * @param  upperBound The upper & originalUpper field of NumberGuesser superclass
	 */
	public RandomNumberGuesser(int lowerBound, int upperBound) {
		super(lowerBound, upperBound);
	}

	/**
	 * Get the current guess
	 * Overrides the parent's method
	 * @return the current guess
	 */
	public int getCurrentGuess() {
		// if it is the first time generate a guess
		if (this.firstCall) {
			this.currentGuess = this.generateRandomIntInRange();
			firstCall = false;
		// if either .higher or .lower in the superclass is called
		} else if (generateRandInt) {
			// generate rand int again
			// update property currentGuess
			this.currentGuess = this.generateRandomIntInRange();
			resetGenerateRandInt();
		}
		
		// return currentGuess	 
		return currentGuess;
	}

	public int generateRandomIntInRange() {
		int range = (upper - lower);
		return (int)(Math.random() * range) + lower;
	}
}