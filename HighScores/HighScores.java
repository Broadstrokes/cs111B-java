public class HighScores {

	private String name;
	private int score;

	public HighScores(String n, int s) {
		name = n;
		score = s;
	}

	void setName(String n) { 
		name = n;
	}
	
	void setScore(int s) {
		score = s;
	}

	String getName() {
		return name;
	}
	
	int getScore() {
		return score;
	}
}