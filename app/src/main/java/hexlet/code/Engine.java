package hexlet.code;

import java.util.Scanner;
import java.util.Random;

/**
 * Основной класс-движок для работы с играми.
 * Содержит базовые функции для взаимодействия с пользователем и обработки игр.
 */
public class Engine {

    // Статический сканер для ввода данных от пользователя
    private static final Scanner USER_INPUT = new Scanner(System.in);

    // Имя пользователя
    private static String name;

    // Генератор случайных чисел
    private static final Random RANDOM = new Random();

    // Количество раундов по умолчанию
    private static final int COUNT_OF_ROUNDS = 3;

    /**
     * Возвращает количество раундов в игре.
     *
     * @return количество раундов
     */
    public static int getRounds() {
        return COUNT_OF_ROUNDS;
    }

    /**
     * Получает ввод от пользователя.
     *
     * @return введенную строку
     */
    public static String getChoice() {
        return USER_INPUT.nextLine();
    }

    /**
     * Приветствует пользователя и получает его имя.
     *
     * @param greeting дополнительное приветственное сообщение
     */
    public static void getGreeting(String greeting) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name?: ");
        name = getChoice();
        System.out.println("Hello, " + name + "!");
        System.out.println(greeting);
    }

    /**
     * Генерирует случайное число в диапазоне от 1 до 30.
     *
     * @return случайное число
     */
    public static int getRandomNumber() {
        final int defaultRange = 30;
        return RANDOM.nextInt(defaultRange) + 1;
    }

    /**
     * Генерирует случайное число в указанном диапазоне.
     *
     * @param range верхний предел диапазона
     * @return случайное число
     */
    public static int getRandomNumber(int range) {
        return RANDOM.nextInt(range) + 1;
    }

    /**
     * Проверяет правильность ответа пользователя.
     *
     * @param answer ответ пользователя
     * @param current правильный ответ
     * @return true если ответы совпадают, иначе false
     */
    public static boolean setCheckingOptions(String answer, String current) {
        return answer.equals(current);
    }

    /**
     * Основной игровой процесс: выводит вопрос, получает ответ и проверяет его.
     *
     * @param task вопрос/задача
     * @param current правильный ответ
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

    /**
     * Поздравляет пользователя с победой.
     */
    public static void win() {
        System.out.println("Congratulations, " + name + "!");
    }

    /**
     * Закрывает сканер ввода.
     */
    public static void setClose() {
        USER_INPUT.close();
    }
}
