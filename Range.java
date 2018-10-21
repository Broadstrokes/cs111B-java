public class Range {
	private int lowerBound;
	private int upperBound;


	public Range(int lower, int upper) {
		this.lowerBound = lower;
		this.upperBound = upper;
	}

	public void setLowerBound(int value) {
		this.lowerBound = value;
	}

	public int getLowerBound() {
		return this.lowerBound;
	}

	public void setUpperBound(int value) {
		this.upperBound = value;
	}


	public int getUpperBound() {
		return this.upperBound;
	}

	public boolean contains(int value) {
		return (
			(this.lowerBound <= value) && 
			(value <= this.upperBound)
		); 
	}

	public boolean contains(Range range) {
		return (
			(this.lowerBound <= range.lowerBound) &&
			(this.upperBound >= range.upperBound)
		);
	}

	public boolean equals(Range r) {
		return (
			(this.lowerBound == r.lowerBound) && 
			(this.upperBound == r.upperBound)
		);
	}
}	