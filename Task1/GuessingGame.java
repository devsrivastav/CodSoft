package Task1;
import java.util.Random;
import java.util.Scanner;
public class GuessingGame {
	    private static final int MAX_ATTEMPTS = 10; // Max attempts per round
	    private static final int LOWER_BOUND = 1;
	    private static final int UPPER_BOUND = 100;

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Random random = new Random();
	        int roundsWon = 0;

	        boolean playAgain = true;

	        while (playAgain) {
	            int numberToGuess = random.nextInt(UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND;
	            int attemptsLeft = MAX_ATTEMPTS;
	            boolean hasGuessedCorrectly = false;

	            System.out.println("Welcome to the Number Guessing Game!");
	            System.out.println("I have selected a number between " + LOWER_BOUND + " and " + UPPER_BOUND + ".");
	            System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess it.");

	            while (attemptsLeft > 0) {
	                System.out.print("Enter your guess: ");
	                int userGuess = scanner.nextInt();

	                if (userGuess < LOWER_BOUND || userGuess > UPPER_BOUND) {
	                    System.out.println("Guess out of range. Please guess a number between " + LOWER_BOUND + " and " + UPPER_BOUND + ".");
	                    continue;
	                }

	                if (userGuess == numberToGuess) {
	                    System.out.println("Congratulations! You've guessed the number correctly.");
	                    hasGuessedCorrectly = true;
	                    roundsWon++;
	                    break;
	                } else if (userGuess < numberToGuess) {
	                    System.out.println("Too low. Try again.");
	                } else {
	                    System.out.println("Too high. Try again.");
	                }

	                attemptsLeft--;
	                System.out.println("Attempts left: " + attemptsLeft);
	            }

	            if (!hasGuessedCorrectly) {
	                System.out.println("Sorry, you've run out of attempts. The number was " + numberToGuess + ".");
	            }

	            System.out.println("You have won " + roundsWon + " round(s).");

	            System.out.print("Do you want to play again? (yes/no): ");
	            String response = scanner.next();
	            playAgain = response.equalsIgnoreCase("yes");
	        }

	        System.out.println("Thanks for playing! You won " + roundsWon + " round(s) in total.");
	        scanner.close();
	    }
}
