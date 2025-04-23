package hexlet.code;

import java.util.Scanner;
import java.util.Random;

/**
 * Основной класс, управляющий игровым процессом.
 */
public class Engine {

    private static final Scanner USER_INPUT = new Scanner(System.in);
    private static String name;
    private static final Random RANDOM = new Random();
    private static final int COUNT_OF_ROUNDS = 3;

    public static int getRounds() {
        return COUNT_OF_ROUNDS;
    }

    /**
     * Получение ввода от пользователя.
     *
     * @return введенная строка
     */
    public static String getChoice() {
        return USER_INPUT.nextLine();
    }

    /**
     * Приветствие и получение имени игрока.
     */
    public static void getGreeting(String greeting) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name?: ");
        name = getChoice();
        System.out.println("Hello, " + name + "!");
        System.out.println(greeting);
    }

    /**
     * Генерация случайного числа.
     *
     * @return случайное число в заданном диапазоне
     */
    public static int getRandomNumber() {
        final int defaultRange = 30;
        return RANDOM.nextInt(defaultRange) + 1;
    }

    /**
     * Генерация случайного числа с указанным диапазоном.
     *
     * @param range заданный диапазон
     * @return случайное число
     */
    public static int getRandomNumber(int range) {
        return RANDOM.nextInt(range) + 1;
    }

    /**
     * Настройка параметров проверки ответа.
     */
    public static boolean setCheckingOptions(String answer, String current) {
        return answer.equals(current);
    }

    /**
     * Основной игровой цикл.
     * Выполняет заданное количество раундов игры.
     */
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

    /**
     * Закрывает ввод данных от пользователя.
     */
    public static void setClose() {
        USER_INPUT.close();
    }
}
