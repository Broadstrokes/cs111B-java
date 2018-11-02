import java.util.Scanner;

/*
  Rewrite the high scores assignment so that the names and scores are stored
  in an array of HighScore objects instead of parallel ArrayLists.
*/

public class HighScoresProgram {
  public static void main(String[] args) {

    final int NUM_SCORES = 5;
    HighScores[] scores = new HighScores[NUM_SCORES];

    initialize(scores);
    sort(scores);
    display(scores);
  }

  public static void initialize(HighScores[] scores) {
    Scanner input = new Scanner(System.in);

    final String PROMPT1 = "Enter the name for score #";
    final String PROMPT2 = "Enter the score for score #";

    for (int i = 0; i < scores.length; i++) {
      String name = "";
      int score = 0;

      print(PROMPT1 + (i + 1) + ": ");
      name = input.next();
      print(PROMPT2 + (i + 1) + ": ");
      score = input.nextInt();
      
      scores[i] = new HighScores(name, score);
    }
  }

  public static void sort(HighScores[] scores) {
    int indexToSwap;
    int size = scores.length;

    for (int i = 0; i < size; i++) {
      indexToSwap = findIndexOfLargest(scores, i, size);
      
      HighScores temp = scores[i];
      scores[i] = scores[indexToSwap];
      scores[indexToSwap] = temp;
    }
  }

  public static void display(HighScores[] scores) {
    println("Top Scorers:");
    for (HighScores scoresObj : scores)
      println(scoresObj.getName() + ": " + scoresObj.getScore());
  }

  ////////////////////
  // HELPER METHODS //
  ////////////////////

  /*
  Helper method for sort
  */
  public static int findIndexOfLargest(HighScores[] scores, int startingIndex, int numItems) {
    int indexOfLargest = startingIndex;

    for (int i = startingIndex + 1; i < numItems; i++) {
      if (scores[i].getScore() > scores[indexOfLargest].getScore()) {
        indexOfLargest = i;
      }
    }

    return indexOfLargest;
  }

  public static void println(Object line) {
    System.out.println(line);
  }
  public static void print(Object line) {
    System.out.print(line);
  }
}