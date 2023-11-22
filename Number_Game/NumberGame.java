import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        HashMap<String, Integer> scoreBoard = new HashMap<>();
        final int minRange = 1;
        final int maxRange = 100;
        final int maxAttempts = 5;
        int totalScore = 0;
        int round = 0;
        boolean gameOver = false;

        while (!gameOver) {
            int attempt = 0;
            round++;
            System.out.println("\n--*--ROUND " + round + "--*--");
            int randomNumber = random.nextInt(maxRange) + minRange;
            while (attempt < maxAttempts) {
                System.out.print("\nEnter your guess: ");
                int userGuess = input.nextInt();
                attempt++;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You have Guessed Correct Number");
                    totalScore += maxAttempts - attempt + 1;
                    break;
                } else {
                    System.out.println(getFeedback(randomNumber, userGuess));
                    System.out.println("You have only " + (maxAttempts - attempt) + " attempts more");
                }
            }
            scoreBoard.put("Round-" + round, attempt);
            System.out.print("Do you want to play another round (Y/N) : ");
            char c = input.next().toLowerCase().charAt(0);
            if (c == 'n') {
                gameOver = true;
                displatScoreBoard(scoreBoard);
                System.out.println("Total Score is " + totalScore);
            }
        }
    }

    static String getFeedback(int randomNumber, int userNumber) {
        // Algorithm for feedback
        // if the userNumber is less than randomNumber , then the feedback will be low
        // if the userNumber is less than half of randomNumber , then the feedback will be too low
        // if the userNumber is less than randomNumber , then the feedback will be high
        // if the userNumber is more than randomNumber * 2  , then the feedback will be too high

        String feedback = "Your guess number is ";
        if (userNumber < randomNumber) {
            if (userNumber < randomNumber / 2) {
                feedback += "too low";
            } else {
                feedback += "low";
            }
        } else {
            if (userNumber > randomNumber * 2) {
                feedback += "too high";
            } else {
                feedback += "high";
            }
        }
        return feedback;
    }

    static void displatScoreBoard(HashMap<String, Integer> scoreBoard) {
        for (String round : scoreBoard.keySet()) {
            System.out.println(round + " -> " + scoreBoard.get(round) + " attempts");
        }
    }
}