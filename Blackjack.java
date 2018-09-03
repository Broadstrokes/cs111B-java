    /* Dan Sajjad */


    // instantiate necessary variables
    // start loop that keeps the game in play
    // generate 1st & 2nd card randomly
    // start loop 2 that keeps asking user if user wants to draw another card
    // until the user looses, wins or says no
    // the inner loop is now over
    // Print the necessary messages
    // ask if user wants to replay

    import java.util.Scanner;
    import java.util.Random;

    public class Blackjack {

        private static int randGenerator() {
            Random generator = new Random();
            return generator.nextInt(10) + 1;
        }

        public static void main (String args[]) {
            Scanner input = new Scanner(System.in);

            int JACKPOT = 21;
            String PLAY_AGAIN = "Would you like to play again? (y/n): ";
            String DRAW_ANOTHER = "Do you want another card? (y/n): ";
            char drawAnotherCard;
            char play = 'y';
            int playerScore;
            int card1;
            int card2;

            while (play == 'y') {
                drawAnotherCard = 'y';
                card1 = randGenerator();
                card2 = randGenerator();
                playerScore = card1 + card2;

                System.out.println("First cards: " + card1 + ", " + card2);
                System.out.println("Total: " + playerScore);

                while(playerScore < JACKPOT && drawAnotherCard == 'y') {
                    // Ask if user wants another card? 
                    System.out.println(DRAW_ANOTHER);
                    drawAnotherCard = input.next().charAt(0);
                    card1 = randGenerator();
                    playerScore += card1;

                    System.out.println("Card: " + card1);
                    System.out.println("Total: " + playerScore);
                }

                if (playerScore == JACKPOT) {
                    System.out.println("You won!");
                } else if (playerScore > JACKPOT) {
                    System.out.println("Bust.");
                }

                System.out.println(PLAY_AGAIN);
                play = input.next().charAt(0);
            }
        }
    }