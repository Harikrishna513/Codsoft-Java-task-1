import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minNumber = 1;
        int maxNumber = 100;
        int maxAttempts = 10;
        int roundsPlayed = 0;
        int totalAttempts = 0;

        System.out.println("Welcome to the Guessing Game!");
        boolean playAgain = true;

        while (playAgain) {
            int secretNumber = random.nextInt(maxNumber - minNumber + 1) + minNumber;
            int attempts = 0;

            System.out.println("\nRound " + (roundsPlayed + 1));
            System.out.println("Guess the number between " + minNumber + " and " + maxNumber);

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > secretNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    totalAttempts += attempts;
                    break;
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Out of attempts. The secret number was: " + secretNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            if (!playAgainInput.equals("yes")) {
                playAgain = false;
                System.out.println("Thanks for playing!");
                System.out.println("Total rounds played: " + (roundsPlayed + 1));
                System.out.println("Average attempts per round: " + (double) totalAttempts / (roundsPlayed + 1));
            } else {
                roundsPlayed++;
            }
        }

        scanner.close();
    }
}
