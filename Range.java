 public class Range {
	private 
		int lowerBound;
		int upperBound;


  Range(int lower, int upper) {
		lowerBound = lower;
		upperBound = upper;
  }

  void setLowerBound(int value) {
		lowerBound = value;
  }

  int getLowerBound() {
		return lowerBound;
  }

  void setUpperBound(int value) {
		upperBound = value;
  }


  int getUpperBound() {
		return upperBound;
  }

  boolean contains(int value) {
		return (
			(lowerBound <= value) && 
			(value <= upperBound)
		); 
  }

  boolean contains(Range range) {
		return (
			(lowerBound <= range.lowerBound) &&
			(upperBound >= range.upperBound)
		);
  }

  boolean equals(Range r) {
		return (
			(lowerBound == r.lowerBound) && 
			(upperBound == r.upperBound)
		);
  }
 }	