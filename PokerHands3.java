import java.util.Arrays;
import java.util.Scanner;

/////////////////////////////////////
// Solve PokerHands in linear time //
/////////////////////////////////////


public class PokerHands3 {

  public static void main(String[] args) {
    final int ARRAY_SIZE = 5;
    int[] cardFrequecies = getFrequencies(ARRAY_SIZE);
    getHandType(cardFrequecies, ARRAY_SIZE);
  }


  public static void println(Object line) { System.out.println(line); }
  public static void print(Object line) { System.out.print(line); }
  
  public static int[] getFrequencies(int numItems) {
    Scanner input = new Scanner(System.in);
    int[] countsArray = new int[10];

    for (int i = 0; i < numItems; i++) {
      println("Enter five numeric cards, no face cards. Use 2 - 9.");
      print("Card " + (i + 1) + ": ");

      int index = input.nextInt();
      countsArray[index] = countsArray[index] + 1;
    }

    return countsArray;
  }

  public static void getHandType(int cardFrequecies[], int totalNumOfCards) {
    int idxStart = 0, idxEnd = 0, numCardsSeen = 0, pairCount = 0;
    boolean skippedCardInSequence = false;
    // Type of hands
    boolean containsFourOfaKind = false;
    boolean containsFullHouse = false;
    boolean containsStraight = false;
    boolean containsThreeOfaKind = false;
    boolean containsTwoPairs = false;
    boolean containsSinglePair = false;

    while (cardFrequecies[idxStart] < 1) {
      idxStart++;
    }

    for (int i = idxStart; numCardsSeen < totalNumOfCards; i++) {
      if (cardFrequecies[i] == 0) { 
        skippedCardInSequence = true;
      } else if (cardFrequecies[i] == 4) {
        containsFourOfaKind = true;
        numCardsSeen += 4;
      } else if (cardFrequecies[i] == 3) {
        containsThreeOfaKind = true;
        numCardsSeen += 3;
      } else if (cardFrequecies[i] == 2 && pairCount > 0) {
        pairCount++;
        numCardsSeen += 2;
        containsTwoPairs = true;
        containsSinglePair = false; // Prevent double counting
      } else if (cardFrequecies[i] == 2) {
        pairCount++;
        numCardsSeen += 2;
        containsSinglePair = true;
      } else {
        numCardsSeen += 1;
      }

      if (numCardsSeen == totalNumOfCards) { idxEnd = i; }
    }

    containsFullHouse = containsThreeOfaKind && containsSinglePair;
    containsStraight = !skippedCardInSequence && (idxEnd - idxStart + 1 == 5);

    if (containsFourOfaKind) println("Four of a kind!");
    else if (containsFullHouse) println("Full House!");
    else if (containsStraight) println("Straight!");
    else if (containsThreeOfaKind) println("Three of a kind!");
    else if (containsTwoPairs) println("Two Pair!");
    else if (containsSinglePair) println("Pair!");
    else println("High Card!");
  }
}
