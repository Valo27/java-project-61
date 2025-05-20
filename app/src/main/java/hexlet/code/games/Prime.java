package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.GameConfig;
import hexlet.code.Utils;

/**
 * Класс для игры "Простое число".
 * Проверяет, является ли число простым
 */
public class Prime {

    /**
     * Максимальное число для генерации случайных чисел.
     * Определяет диапазон чисел, которые будут проверяться на простоту
     */
    private static final int RANDOM_MAX_NUMBER = 100;

    /**
     * Правила игры (константа класса).
     */
    private static final String GAME_RULES =
            "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    /**
     * Основной метод запуска игры.
     * Создает вопросы и ответы для игры
     * Запускает игровой процесс
     */
    public static void gamePrime() {
        // Получаем количество раундов из конфигурации
        int rounds = GameConfig.getMaxRounds();

        // Создаем массив для хранения вопросов и ответов
        String[][] questAnswers = new String[rounds][2];

        // Генерируем вопросы и ответы для всех раундов
        for (int i = 0; i < rounds; i++) {
            // Генерируем случайное число
            int number = Utils.random(RANDOM_MAX_NUMBER);

            // Формируем вопрос (просто число в виде строки)
            questAnswers[i][0] = Integer.toString(number);

            // Определяем правильный ответ ('yes' или 'no')
            questAnswers[i][1] = isPrime(number) ? "yes" : "no";
        }

        // Запускаем основной игровой процесс
        Engine.gameStart(GAME_RULES, questAnswers);
    }

    /**
     * Метод проверки числа на простоту.
     * @param number проверяемое число
     * @return true если число простое, false в противном случае
     */
    private static boolean isPrime(int number) {
        // Добавляем проверку на числа <= 1
        if (number <= 1) {
            return false;
        }

        // Начинаем проверку с числа 2
        int numberSecond = 2;

        // Определяем верхнюю границу проверки как квадратный корень
        int maxCheck = (int) Math.sqrt(number);

        // Проверяем делимость числа до его квадратного корня
        while (numberSecond <= maxCheck) {
            // Если число делится без остатка, оно не простое
            if (number % numberSecond == 0) {
                return false;
            }
            numberSecond++;
        }

        // Если цикл завершился, число простое
        return true;
    }
}
