import java.util.Scanner;

public class PokerHands{
    public static void main(String[] args) {
        final int ARRAY_SIZE = 5;
        int[] hand = readNumbers(ARRAY_SIZE);
        
        if (containsFourOfaKind(hand)) {
            System.out.println("Four of a kind!");
        } else if (containsFullHouse(hand)) {
            System.out.println("Full House!");
        } else if (containsStraight(hand)) {
            System.out.println("Straight!");
        } else if (containsThreeOfaKind(hand)) {
            System.out.println("Three of a kind!");
        } else if (containsTwoPair(hand)) {
            System.out.println("Two Pair!");
        } else if (containsPair(hand)) {
            System.out.println("Pair!");
        } else {
            System.out.println("High Card!");
        }
    }


    public static int[] readNumbers(int arraySize) {
        Scanner input = new Scanner(System.in);
        
        int[] list = new int[arraySize];
        int number;

        
        for (int i = 0; i < arraySize; i++) {
            System.out.println("Enter five numeric cards, no face cards. Use 2 - 9.");
            System.out.print("Card " + (i + 1) + ": ");            
            list[i] = input.nextInt();
        }

        return list;
    }

    public static int numOccurances(int hand[], int card, int startIndex) {
        int occurances = 0;

        for (int i = startIndex; i < hand.length; i++) {
            if (card == hand[i]) {
                occurances++;
            }
        }

        return occurances;
    }

    public static boolean containsPair(int hand[]) {
        int numPairs = 0;

        for (int i = 0; i < hand.length; i++) {
            if (numOccurances(hand, hand[i], i) == 2) {
                numPairs++;
            }
        }

        if (containsThreeOfaKind(hand)) {
            return false;
        } else if (containsFourOfaKind(hand)) {
            return false;
        } else if (numPairs >= 1) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean containsTwoPair(int hand[]) {
        int numPairs = 0;
        
        for (int i = 0; i < hand.length; i++) {
            if (numOccurances(hand, hand[i], i) == 2) {
                numPairs++;
            }
        }
        if (containsThreeOfaKind(hand)) {
            return false;
        } else if (numPairs >= 2) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean containsThreeOfaKind(int hand[]) {
        for (int i = 0; i < hand.length; i++) {
            if (containsFourOfaKind(hand)) {
                return false;
            } else if (numOccurances(hand, hand[i], i) == 3) {
                return true;
            }
        }
        
        return false;
    }

    public static int getSmallest(int hand[]) {
        int smallest = hand[0];
        for (int i = 0; i < hand.length; i++) {
            if (smallest > hand[i]) {
                smallest = hand[i];
            }
        }
        return smallest;
    }

    public static boolean hasNextItemInSequence(int hand[], int current) {
        int nextItem = current + 1;
        for (int i = 0; i < hand.length; i++) {
            if (nextItem == hand[i]) {
                return true;
            }
        }
        return false;
    }

    public static int getThreeOfAKindsValue(int hand[]) {
        for (int i = 0; i < hand.length; i++) {
            if (numOccurances(hand, hand[i], i) == 3) {
                return hand[i];
            }
        }
        return -1;
    }

    public static boolean containsStraight(int hand[]) {
        int current = getSmallest(hand);
        
        if (containsPair(hand)) {
            return false;
        } else {
            for (int i = 0; i < hand.length - 1; i++) {
                if (!hasNextItemInSequence(hand, current)) {
                    return false;
                } else {
                    current = current + 1;
                }
            }
        }
        return true;
    }

    public static boolean containsFullHouse(int hand[]) {
        int threeOfAKindsValue;
        
        if (containsThreeOfaKind(hand)) {
            threeOfAKindsValue = getThreeOfAKindsValue(hand);
            for (int i = 0; i < hand.length; i++) {
                if (hand[i] != threeOfAKindsValue) {
                    return numOccurances(hand, hand[i], i) == 2;
                }
            }
        }
        
        return false;    
    }

    public static boolean containsFourOfaKind(int hand[]) {
        for (int i = 0; i < hand.length; i++) {
            if (numOccurances(hand, hand[i], i) == 4) {
                return true;
            }
        }
        
        return false;
    }

}
