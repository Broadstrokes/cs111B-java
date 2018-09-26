import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class HighScores {


 public static void main(String[] args) {
  ArrayList < String > names = new ArrayList < > (5);
  ArrayList < Integer > scores = new ArrayList < > (5);

  initialize(names, scores);
  sort(names, scores);
  display(names, scores);
 }


 public static void initialize(ArrayList < String > names, ArrayList < Integer > scores) {
  Scanner input = new Scanner(System.in);
  int size = 5;
  int count = 0;
  final String PROMPT1 = "Enter the name for score #";
  final String PROMPT2 = "Enter the score for score #";

  while (count < size) {
   count++;

   print(PROMPT1 + count + ": ");
   names.add(input.next());
   print(PROMPT2 + count + ": ");
   scores.add(input.nextInt());
  }
 }

 public static void sort(ArrayList < String > names, ArrayList < Integer > scores) {
  int indexToSwap;
  int size = scores.size();

  for (int i = 0; i < size; i++) {
   indexToSwap = findIndexOfLargest(scores, i, size);
   Collections.swap(scores, i, indexToSwap);
   Collections.swap(names, i, indexToSwap);
  }
 }

 public static void display(ArrayList < String > names, ArrayList < Integer > scores) {
  int count = 0;
  int size = scores.size();

  println("Top Scorers: ");

  while (count < size) {
   println(names.get(count) + ": " + scores.get(count));
   count++;
  }
 }

 ////////////////////
 // HELPER METHODS //
 ////////////////////

 /*
 	Helper method for sort
  */
 public static int findIndexOfLargest(ArrayList < Integer > scores, int startingIndex, int numItems) {
  int indexOfLargest = startingIndex;

  for (int i = startingIndex + 1; i < numItems; i++) {
   if (scores.get(i) > scores.get(indexOfLargest)) {
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