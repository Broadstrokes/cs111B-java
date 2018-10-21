import java.lang.*; // Double.compare

/*
	Double.compare returns 
	the value 0 if d1 is numerically equal to d2; 
	a value less than 0 if d1 is numerically less than d2; 
	and a value greater than 0 if d1 is numerically greater than d2.

	.equal vs ==
	In simple words, == checks if both objects point to the same 
	memory location whereas .equals() evaluates to the comparison 
	of values in the objects.

	String s1 = new String("HELLO"); 
	String s2 = new String("HELLO"); 
	System.out.println(s1 == s2);  // false
	System.out.println(s1.equals(s2)); // true

 */


public class BARTTrain {
	private String nextStation;
	private double milesPerHour;
	private double milesToNextStation;
	private boolean inbound;

	public BARTTrain() {
		this.nextStation = "";
		this.milesPerHour = 1;
		this.milesToNextStation = 0;
		this.inbound = false;
	}

	public BARTTrain(String station, double mph, double miles, boolean isInbound) {
		this.nextStation = station;
		this.milesPerHour = mph;
		this.milesToNextStation = miles;
		this.inbound = isInbound;
	}

	public void setNextStation(String s) { 
		this.nextStation = s;
	}
	public String getNextStation() { 
		return this.nextStation;
	}	
	public boolean isInbound() { 
		return this.inbound;
	}
	public double getMinutesToNextStation() { 
		return (this.milesToNextStation / this.milesPerHour);
	}
	public void switchInbound() { 
		this.inbound = !this.inbound;
	}

	public boolean equals(BARTTrain t) {
		return (
		// same direction
			this.isInbound() == t.isInbound() &&
		// same place
			(this.getNextStation().equals(t.getNextStation())) &&
		// same speed
			Double.compare(this.getMinutesToNextStation(), t.getMinutesToNextStation()) == 0
		);
	}

	public String toString() {
		return (
			(this.isInbound() ? "Inbound" : "Outbound")
			+ ". " +
			this.getNextStation() + " in " + 
			this.getMinutesToNextStation()
		);
	}
}