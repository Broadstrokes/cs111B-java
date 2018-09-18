import java.util.Scanner;

public class PokerHands{
    public static void main(String[] args) {
        final int ARRAY_SIZE = 5;
        int[] userInput = readNumbers(ARRAY_SIZE);

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
        
        // System.out.println("After insertion");

        // for (int val : list) {
        //     System.out.println(val);
        // }

        return list;
    }

    public static boolean  containsPair(int hand[]) {}

    public static boolean  containsTwoPair(int hand[]) {}

    public static boolean  containsThreeOfaKind(int hand[]) {}

    public static boolean  containsStraight(int hand[]) {}

    public static boolean  containsFullHouse(int hand[]) {}

    public static boolean  containsFourOfaKind(int hand[]) {}
}
