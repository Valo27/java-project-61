package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import java.util.Scanner;
import java.util.Random;

public class Engine {
    private static Scanner userInput = new Scanner(System.in);
    private static String name;
    private static String currentGame;
    private static Random random = new Random();
    private static int countOfRounds = 3;
    private static String task;
    private static String answer;
    private static Boolean isCorrectAnswer;
    private static String rightAnswer;

    public static String getChoice() {
        return userInput.nextLine();
    }

    public static void getGreeting() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name?: ");
        name = getChoice();
        System.out.println("Hello, " + name + "!");
    }

    public static int getRandomNumber() {
        int defaultRange = 30; //set range of random numbers
        return random.nextInt(defaultRange) + 1;
    }

    public static int getRandomNumber(int range) { //when need specific range
        return random.nextInt(range) + 1;
    }

    public static void startChosenGame(String choice) {
        if (choice.equals("1")) {
            currentGame = "Greet";
            Engine.getGreeting();
        }

        if (choice.equals("2")) {
            currentGame = "Even";
            Engine.getGreeting();
            Even.getGameQuestion();
            gameRoutine();
        }

        if (choice.equals("3")) {
            currentGame = "Calc";
            Engine.getGreeting();
            Calc.getGameQuestion();
            gameRoutine();
        }

        if (choice.equals("0")) {
            System.out.println("Bye.");
        }
    }

    public static void setTask() {
        switch (currentGame) {
            case "Even":
                task = String.valueOf(Even.getTask());
                break;
            case "Calc":
                task = Calc.getTask();
                break;
            default:
                break;
        }
    }

    public static void setCheckingOptions() {
        switch (currentGame) {
            case "Even":
                isCorrectAnswer = Even.checkAnswer();
                rightAnswer = Even.getRightAnswer();
                break;
            case "Calc":
                isCorrectAnswer = Calc.checkAnswer();
                rightAnswer = Calc.getRightAnswer();
                break;
            default:
                break;
        }
    }

    public static String getTask() {
        return task;
    }

    public static String getAnswer() {
        return answer;
    }

    public static void gameRoutine() {
        int rightAnswers = 0;

        for (var i = 1; i <= countOfRounds; i++) {
            setTask();
            System.out.println("Question: " + task);
            System.out.print("Your answer: ");
            answer = Engine.getChoice();
            setCheckingOptions();
            if (isCorrectAnswer) {
                System.out.println("Correct!");
                rightAnswers += 1;
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + rightAnswer + "'");
                System.out.println("Let's try again, " + name + "!");
                break;
            }
        }

        if (rightAnswers == 3) {
            System.out.println("Congratulations, " + name + "!");
        }
    }

    public static void setClose() {
        userInput.close();
    }
}
