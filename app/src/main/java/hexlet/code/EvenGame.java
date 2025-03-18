package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class EvenGame {
    private static final int MAX_ATTEMPTS = 3;
    private static final int MAX_NUMBER = 100;

    public static void start(Scanner scanner) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        int correctAnswers = 0;
        Random random = new Random();

        while (correctAnswers < MAX_ATTEMPTS) {
            int number = random.nextInt(MAX_NUMBER);
            String correctAnswer = isEven(number) ? "yes" : "no";

            System.out.println("Question: " + number);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine().toLowerCase();

            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                System.out.print("'" + userAnswer + "' is wrong answer ;(");
                System.out.println(". Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + name + "!");
                return;
            }
        }

        System.out.println("Congratulations, " + name + "!");
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
