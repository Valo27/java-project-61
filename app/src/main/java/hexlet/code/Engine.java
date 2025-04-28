package hexlet.code;

import java.util.Scanner;
import java.util.Random;

public class Engine {

    private static final Scanner USER_INPUT = new Scanner(System.in);
    private static String name;
    private static final Random RANDOM = new Random();
    private static final int COUNT_OF_ROUNDS = 3;

    public static int getRounds() {
        return COUNT_OF_ROUNDS;
    }

    public static String getChoice() {
        return USER_INPUT.nextLine();
    }

    public static void getGreeting(String greeting) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name?: ");
        name = getChoice();
        System.out.println("Hello, " + name + "!");
        System.out.println(greeting);
    }

    public static int getRandomNumber() {
        final int defaultRange = 30;
        return RANDOM.nextInt(defaultRange) + 1;
    }

    public static int getRandomNumber(int range) {
        return RANDOM.nextInt(range) + 1;
    }

    public static boolean setCheckingOptions(String answer, String current) {
        return answer.equals(current);
    }

    public static void gameRoutine(String task, String current) {

        System.out.println("Question: " + task);
        System.out.print("Your answer: ");
        String answer = Engine.getChoice();
        boolean checkAnswer = setCheckingOptions(answer, current);
        if (checkAnswer) {
            System.out.println("Correct!");
        } else {
            System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + current + "'");
            System.out.println("Let's try again, " + name + "!");
            System.exit(0);
        }
    }

    public static void win() {
        System.out.println("Congratulations, " + name + "!");
    }

    public static void setClose() {
        USER_INPUT.close();
    }
}
