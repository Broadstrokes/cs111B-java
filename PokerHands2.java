/**
We are ignoring card suits there won’t be any flushes. Your program should be 
able to recognize the following hand categories, listed from least valuable to most valuable:


High Card - There are no matching cards, and the hand is not a straight
{2, 5, 3, 8, 7}

Pair - Two of the cards are identical
{2, 5, 3, 5, 7}

Two Pair - Two different pairs
{2, 5, 3, 5, 3}

Three of a kind - Three matching cards
{5, 5, 3, 5, 7}

Straight - Card values can be arranged in order
{3, 4, 5, 6, 7}

Full House - A pair, and a three of a kind
{5, 7, 5, 7, 7}

Four of a kind - Four matching cards
{2, 5, 5, 5, 5}

(A note on straights: a hand is a straight regardless of the order. So the values 
3, 4, 5, 6, 7 represent a straight, but so do the values 7, 4, 5, 6, 3)
Your program should read in five values and then print out the appropriate hand type.
If a hand matches more than one description, the program should print out the most 
valuable hand type.

Here is are three sample runs of the program:


Enter five numeric cards, no face cards. Use 2 - 9.
Card 1: 8 
Card 2: 7
Card 3: 8
Card 4: 2
Card 5: 7
Two Pair!


Enter five numeric cards, no face cards. Use 2 - 9.
Card 1: 4 
Card 2: 5
Card 3: 6
Card 4: 8
Card 5: 7
Straight!


Enter five numeric cards, no face cards. Use 2 - 9.
Card 1: 9
Card 2: 2
Card 3: 3
Card 4: 4
Card 5: 5
High Card!
*/

import java.util.Arrays;
import java.util.Scanner;

public class PokerHands2 {
  public static void main(String[] args) {
		final int ARRAY_SIZE = 5;
		int[] counts = getCounts(ARRAY_SIZE);
		// println(Arrays.toString(counts));

    if (containsFourOfaKind(counts)) {
        System.out.println("Four of a kind!");
    } else if (containsFullHouse(counts)) {
        System.out.println("Full House!");
    } else if (containsStraight(counts)) {
        System.out.println("Straight!");
    } else if (containsThreeOfaKind(counts)) {
        System.out.println("Three of a kind!");
    } else if (containsTwoPair(counts)) {
        System.out.println("Two Pair!");
    } else if (containsPair(counts)) {
        System.out.println("Pair!");
    } else {
        System.out.println("High Card!");
    }

				    ////////////////
				    // TEST CASES //
				    ////////////////

    // println(containsPair(counts));
    // println(containsTwoPair(counts));
    // println(containsThreeOfaKind(counts));
    // println(containsStraight(counts));
    // println(containsFullHouse(counts));
    // println(containsFourOfaKind(counts));

    // println(">>>>>>>>>>");

    // int[] highCard = {2, 5, 3, 8, 7};
    // int[] pair = {2, 5, 3, 5, 7};
    // int[] twoPair = {2, 5, 3, 5, 3};
    // int[] threeOfAKind = {5, 5, 3, 5, 7};
    // int[] straight1 = {3, 4, 5, 6, 7};
    // int[] straight2 = {7, 4, 5, 6, 3};
    // int[] fullHouse = {5, 7, 5, 7, 7};
    // int[] fourOfAKind = {2, 5, 5, 5, 5};

    // int[][] myHands = {
    //   highCard, pair, twoPair, threeOfAKind, straight1, straight2, fullHouse, fourOfAKind
    // };

    // for(int i = 0; i < myHands.length; i++) {
    //   int[] counts = getCountsFromArr(myHands[i]);
    //   // println(">>>>>>>");
    //   // println(Arrays.toString(myHands[i]));
    //   // println(Arrays.toString(counts));
    //   // println(">>>>>>>");
    //   // println("high: " + isHighCard(counts));
    //   // println("pair: " + containsPair(counts));
    //   // println("twoPair: " + containsTwoPair(counts));
    //   // println("threeOfAKind: " + containsThreeOfaKind(counts));
    //   // println("straight: " + containsStraight(counts));
    //   // println("fullHouse: " + containsFullHouse(counts));
    //   // println("fourOfAKind: " + containsFourOfaKind(counts));

    //   if (containsFourOfaKind(counts)) {
    //       System.out.println("Four of a kind!");
    //   } else if (containsFullHouse(counts)) {
    //       System.out.println("Full House!");
    //   } else if (containsStraight(counts)) {
    //       System.out.println("Straight!");
    //   } else if (containsThreeOfaKind(counts)) {
    //       System.out.println("Three of a kind!");
    //   } else if (containsTwoPair(counts)) {
    //       System.out.println("Two Pair!");
    //   } else if (containsPair(counts)) {
    //       System.out.println("Pair!");
    //   } else {
    //       System.out.println("High Card!");
    //   }
    //     println(">>>>>>>");
    //     println("");
    // }



  }

  public static void println(Object line) { System.out.println(line); }
	public static void print(Object line) { System.out.print(line); }


  public static int[] getCounts(int numItems) {
    Scanner input = new Scanner(System.in);
    int[] countsArray = new int[10];

    for (int i = 0; i < numItems; i++) {
      println("Enter five numeric cards, no face cards. Use 2 - 9.");
      print("Card " + (i + 1) + ": ");

      int index = input.nextInt();
      countsArray[index] = countsArray[index] + 1;
      // println(">>>>> ");
      // println(Arrays.toString(countsArray));
    }

    return countsArray;
  }


  public static int[] getCountsFromArr(int[] hand) {
    int[] countsArray = new int[10];

    for (int i = 0; i < hand.length; i++) {
      int index = hand[i];
      countsArray[index] = countsArray[index] + 1;
    }

    return countsArray;
  }

  public static boolean  containsPair(int hand[]) {
    for(int val : hand) {
      if(val == 2) return true;
    } 
    return false;
  }

  public static boolean  containsTwoPair(int hand[]) {
    int count = 0;
    for(int val : hand) {
      if(val == 2) count++;
    } 
    return count >= 2;
  }

  public static boolean  containsThreeOfaKind(int hand[]) {
    for(int val : hand) {
      if(val == 3) return true;
    } 
    return false;
  }

  public static boolean  containsStraight(int hand[]) {
    int count = 0;
    boolean foundFirstElement = false;
    for (int i = 0; i < hand.length; i++) {
      if (count == 5) { return true; } 
      else {
        if (!foundFirstElement) {
          if (hand[i] > 0) {
            if(hand[i] > 1) { return false; } 
            else {
                foundFirstElement = true;
                count++;
            }
          }
        } else {
          if (hand[i] != 1) { return false; }
          count++;
        }
      } 
    }
      
    return true;
  }

  public static boolean  containsFullHouse(int hand[]) {
    return containsPair(hand) && containsThreeOfaKind(hand);
  }

  public static boolean  containsFourOfaKind(int hand[]) {
    for(int val : hand) {
      if(val == 4) return true;
    } 
    return false;
  }

  public static boolean  isHighCard(int hand[]) {
    return 
    !containsStraight(hand) && 
    !containsFourOfaKind(hand) &&
    !containsThreeOfaKind(hand) && 
    !containsPair(hand);
  }

}


