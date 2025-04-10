package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;
import java.util.Scanner;
import java.util.Random;

/**
 * Основной класс, управляющий игровым процессом
 */
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

    /**
     * Получение ввода от пользователя
     */
    public static String getChoice() {
        return userInput.nextLine();
    }

    /**
     * Приветствие и получение имени игрока
     */
    public static void getGreeting() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name?: ");
        name = getChoice();
        System.out.println("Hello, " + name + "!");
    }

    /**
     * Генерация случайного числа
     */
    public static int getRandomNumber() {
        int defaultRange = 30; //set range of random numbers
        return random.nextInt(defaultRange) + 1;
    }

    public static int getRandomNumber(int range) {
        return random.nextInt(range) + 1;
    }

    /**
     * Запуск выбранной игры
     */
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

        if (choice.equals("4")) {
            currentGame = "GCD";
            Engine.getGreeting();
            GCD.getGameQuestion();
            gameRoutine();
        }

        if (choice.equals("5")) {
            currentGame = "Progression";
            Engine.getGreeting();
            Progression.getGameQuestion();
            gameRoutine();
        }

        if (choice.equals("6")) {
            currentGame = "Prime";
            Engine.getGreeting();
            Prime.getGameQuestion();
            gameRoutine();
        }

        if (choice.equals("0")) {
            System.out.println("Bye.");
        }
    }

    /**
     * Установка задачи для текущего раунда
     */
    public static void setTask() {
        switch (currentGame) {
            case "Even":
                task = String.valueOf(Even.getTask());
                break;
            case "Calc":
                task = Calc.getTask();
                break;
            case "GCD":
                task = GCD.getTask();
                break;
            case "Progression":
                task = Progression.getTask();
                break;
            case "Prime":
                task = Prime.getTask();
                break;
            default:
                break;
        }
    }

    /**
     * Настройка параметров проверки ответа
     */
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
            case "GCD":
                isCorrectAnswer = GCD.checkAnswer(answer, task);
                rightAnswer = GCD.getRightAnswer(task);
                break;
            case "Progression":
                isCorrectAnswer = Progression.checkAnswer(answer);
                rightAnswer = Progression.getRightAnswer();
                break;
            case "Prime":
                isCorrectAnswer = Prime.checkAnswer(answer, task);
                rightAnswer = Prime.getRightAnswer(task);
                break;
            default:
                break;
        }
    }

    /**
     * Возвращает текущую задачу
     */
    public static String getTask() {
        return task;
    }

    /**
     * Возвращает ответ пользователя
     */
    public static String getAnswer() {
        return answer;
    }

    /**
     * Основной игровой цикл
     * Выполняет заданное количество раундов игры
     */
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

    /**
     * Закрывает ввод данных от пользователя
     */
    public static void setClose() {
        userInput.close();
    }
}
