package hexlet.code.games;

import hexlet.code.Engine;

/**
 * Класс для игры "Prime" - проверка чисел на простоту
 */
public class Prime {

    /**
     * Выводит правила игры
     */
    public static void getGameQuestion() {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }

    /**
     * Генерирует случайное число для задачи
     */
    public static String getTask() {
        int number = Engine.getRandomNumber(100);
        return String.valueOf(number);
    }

    /**
     * Проверяет, является ли число простым
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
     * Проверяет правильность ответа пользователя
     */
    public static boolean checkAnswer(String userAnswer, String task) {
        boolean isPrime = isPrime(Integer.parseInt(task));
        String correctAnswer = isPrime ? "yes" : "no";
        return userAnswer.equals(correctAnswer);
    }

    /**
     * Возвращает правильный ответ
     */
    public static String getRightAnswer(String task) {
        boolean isPrime = isPrime(Integer.parseInt(task));
        return isPrime ? "yes" : "no";
    }
}
