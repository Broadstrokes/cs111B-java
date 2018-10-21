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
			this.getNextStation() == t.getNextStation() &&
		// same speed
			this.getMinutesToNextStation() == t.getMinutesToNextStation()
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