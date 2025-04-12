package hexlet.code.games;

import hexlet.code.Engine;

/**
 * Класс для игры "GCD" - нахождение наибольшего общего делителя.
 */
public class GCD {

    /**
     * Выводит правила игры.
     */
    public static void getGameQuestion() {
        System.out.println("Find the greatest common divisor of given numbers.");
    }

    /**
     * Генерирует задачу с двумя числами.
     *
     * @return строку с двумя случайными числами
     */
    public static String getTask() {
        int num1 = Engine.getRandomNumber(100);
        int num2 = Engine.getRandomNumber(100);
        return num1 + " " + num2;
    }

    /**
     * Вычисляет НОД двух чисел.
     *
     * @param a первое число
     * @param b второе число
     * @return наибольший общий делитель чисел a и b
     */
    public static int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /**
     * Проверяет ответ пользователя.
     *
     * @param userAnswer ответ пользователя
     * @param task задача с двумя числами
     * @return true, если ответ правильный, иначе false
     */
    public static boolean checkAnswer(String userAnswer, String task) {
        String[] numbers = task.split(" ");
        int num1 = Integer.parseInt(numbers[0]);
        int num2 = Integer.parseInt(numbers[1]);
        int correctAnswer = calculateGCD(num1, num2);
        return Integer.parseInt(userAnswer) == correctAnswer;
    }

    /**
     * Возвращает правильный ответ.
     *
     * @param task задача с двумя числами
     * @return правильный ответ (НОД двух чисел)
     */
    public static String getRightAnswer(String task) {
        String[] numbers = task.split(" ");
        int num1 = Integer.parseInt(numbers[0]);
        int num2 = Integer.parseInt(numbers[1]);
        return String.valueOf(calculateGCD(num1, num2));
    }
}
