package hexlet.code.games;

import hexlet.code.Engine;

/**
 * Класс для игры "Prime" - проверка чисел на простоту.
 */
public class Prime {

    /**
     * Выводит правила игры.
     */
    public static void getGameQuestion() {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }

    /**
     * Генерирует случайное число для задачи.
     *
     * @return случайное число
     */
    public static String getTask() {
        int number = Engine.getRandomNumber(100);
        return String.valueOf(number);
    }

    /**
     * Проверяет, является ли число простым.
     *
     * @param number проверяемое число
     * @return true, если число простое
     */
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Проверяет правильность ответа пользователя.
     *
     * @param userAnswer ответ пользователя
     * @param task задача
     * @return true, если ответ правильный
     */
    public static boolean checkAnswer(String userAnswer, String task) {
        boolean isPrime = isPrime(Integer.parseInt(task));
        String correctAnswer = isPrime ? "yes" : "no";
        return userAnswer.equals(correctAnswer);
    }

    /**
     * Возвращает правильный ответ.
     *
     * @param task задача
     * @return правильный ответ
     */
    public static String getRightAnswer(String task) {
        boolean isPrime = isPrime(Integer.parseInt(task));
        return isPrime ? "yes" : "no";
    }
}
