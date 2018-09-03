

//  instantiate necessary variables
//  check if playAgain is true using while
//  check if it is the first draw
//  if first draw
//  draw 2 cards
//  print total
//  ask user if user wants another card
//      if yes
//          generate a random #
//          add to running total
//          print total
//              if running total > 21
//                  print "Bust"
//              else if (running total == 21)
//                  print "You win"
//                  ask user if they want to restart
//                      if yes
//                          set playAgain to y
//                      else 
//                          set playAgain to n
//      else 
//          ask user if they want to restart
//              if yes
//                  set playAgain to y
//              else
//                  set playAgain to n 
// 
//
    import java.util.Scanner;
    import java.util.Random;

    public class Blackjack {

        private static int randGenerator() {
            Random generator = new Random();
            return generator.nextInt(10) + 1;
        }

        public static void main (String args[]) {

            System.out.println("Game starting");

            Scanner input = new Scanner(System.in);
            
            char drawAnotherCard = 'y';
            String PLAY_AGAIN = "Would you like to play again? (y/n): ";
            String DRAW_ANOTHER = "Do you want another card? (y/n): ";


            int card1 = randGenerator();
            int card2 = randGenerator();
            int runningTotal = card1 + card2;
            
            System.out.println("First cards: " + card1 + ", " + card2);
            System.out.println("Total: " + runningTotal);

            // Ask if user wants another card? 
            System.out.println(DRAW_ANOTHER);
            drawAnotherCard = input.next().charAt(0);

            while (drawAnotherCard == 'y') {
                // Draw new card
                card1 = randGenerator(); 
                runningTotal += card1;

                // Print 
                System.out.println("Card: " + card1);
                System.out.println("Total: " + runningTotal);

                if (runningTotal > 21) {
                    System.out.println("Bust.");

                    System.out.println(PLAY_AGAIN);
                    drawAnotherCard = input.next().charAt(0);

                    if (drawAnotherCard == 'y') {
                        runningTotal = 0;
                        card1 = randGenerator();
                        card2 = randGenerator();
                        runningTotal = card1 + card2;
                        
                        System.out.println("First cards: " + card1 + ", " + card2);
                        System.out.println("Total: " + runningTotal);

                        // Ask if user wants another card? 
                        System.out.println(DRAW_ANOTHER);
                        drawAnotherCard = input.next().charAt(0);
                    }
                } else if (runningTotal == 21) {
                    System.out.println("You won!");

                    System.out.println(PLAY_AGAIN);
                    drawAnotherCard = input.next().charAt(0);

                    if (drawAnotherCard == 'y') {
                        runningTotal = 0;
                        card1 = randGenerator();
                        card2 = randGenerator();
                        runningTotal = card1 + card2;
                        
                        System.out.println("First cards: " + card1 + ", " + card2);
                        System.out.println("Total: " + runningTotal);

                        // Ask if user wants another card? 
                        System.out.println(DRAW_ANOTHER);
                        drawAnotherCard = input.next().charAt(0);
                    }
                } else {
                    System.out.println(DRAW_ANOTHER);
                    drawAnotherCard = input.next().charAt(0);
                }
            }             
        }
    }
