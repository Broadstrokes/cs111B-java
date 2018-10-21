public class Range {
	private 
		int lowerBound;
		int upperBound;


	Range(int lower, int upper) {
		this.lowerBound = lower;
		this.upperBound = upper;
	}

	void setLowerBound(int value) {
		this.lowerBound = value;
	}

	int getLowerBound() {
		return this.lowerBound;
	}

	void setUpperBound(int value) {
		this.upperBound = value;
	}


	int getUpperBound() {
		return this.upperBound;
	}

	boolean contains(int value) {
		return (
			(this.lowerBound <= value) && 
			(value <= this.upperBound)
		); 
	}

	boolean contains(Range range) {
		return (
			(this.lowerBound <= range.lowerBound) &&
			(this.upperBound >= range.upperBound)
		);
	}

	boolean equals(Range r) {
		return (
			(this.lowerBound == r.lowerBound) && 
			(this.upperBound == r.upperBound)
		);
	}
}	