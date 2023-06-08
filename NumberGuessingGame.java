import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static int highScore = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            System.out.println("\n1. Play Game");
            System.out.println("2. View High Score");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    playGame();
                    break;
                case 2:
                    viewHighScore();
                    break;
                case 3:
                    System.out.println("Thank you for playing. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void playGame() {
        Random random = new Random();
        int secretNumber = random.nextInt(100) + 1; // Generates a random number between 1 and 100
        int attempts = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nLet's play the game!");

        while (attempts < 10) {
            System.out.print("Enter your guess (1-100): ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess == secretNumber) {
                System.out.println("Congratulations! You guessed the secret number in " + attempts + " attempts.");

                if (attempts < highScore) {
                    highScore = attempts;
                    System.out.println("You set a new high score!");
                }

                return;
            } else if (guess < secretNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }

        System.out.println("You have reached the maximum number of attempts. The secret number was: " + secretNumber);
    }

    private static void viewHighScore() {
        if (highScore == Integer.MAX_VALUE) {
            System.out.println("No high score recorded yet.");
        } else {
            System.out.println("The current high score is: " + highScore + " attempts.");
        }
    }
}
