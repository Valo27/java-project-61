package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.GameConfig;
import hexlet.code.Utils;

/**
 * Класс для игры "Наибольший общий делитель"
 * Реализует алгоритм поиска НОД двух чисел
 */
public class GCD {

    /**
     * Максимальное число для генерации случайных чисел
     * Определяет диапазон значений в игре
     */
    private static final int RANDOM_MAX_NUMBER = 100;

    /**
     * Основной метод запуска игры
     * Создает вопросы и ответы для игры
     * Запускает игровой процесс
     */
    public static void gameGCD() {
        // Получаем количество раундов из конфигурации
        int rounds = GameConfig.getMaxRounds();

        // Создаем массив для хранения вопросов и ответов
        String[][] questAnswers = new String[rounds][2];

        // Приветственное сообщение для игры
        String greeting = "Find the greatest common divisor of given numbers.";

        // Генерируем вопросы и ответы для всех раундов
        for (int i = 0; i < rounds; i++) {
            // Генерируем два случайных числа
            int number1 = Utils.random(RANDOM_MAX_NUMBER);
            int number2 = Utils.random(RANDOM_MAX_NUMBER);

            // Формируем правильный ответ
            questAnswers[i][1] = Integer.toString(gcd(number1, number2));

            // Формируем вопрос (два числа через пробел)
            questAnswers[i][0] = number1 + " " + number2;
        }

        // Запускаем основной игровой процесс
        Engine.gameStart(greeting, questAnswers);
    }

    /**
     * Метод нахождения НОД двух чисел
     * @param number1 первое число
     * @param number2 второе число
     * @return наибольший общий делитель
     */
    public static int gcd(int number1, int number2) {
        int result;
        // Убеждаемся, что первое число всегда больше или равно второму
        if (number1 >= number2) {
            result = gcdLogic(number1, number2);
        } else {
            result = gcdLogic(number2, number1);
        }
        return result;
    }

    /**
     * Вспомогательный метод для вычисления НОД
     * Использует алгоритм перебора делителей
     * @param number1 большее число
     * @param number2 меньшее число
     * @return наибольший общий делитель
     */
    private static int gcdLogic(int number1, int number2) {
        int result = 0;
        // Начинаем поиск с половины большего числа
        int isGCD = number1 / 2 == 0 ? 1 : number1 / 2;

        // Ищем НОД, уменьшая число на каждой итерации
        while (isGCD != 0 && result == 0) {
            if (number1 % isGCD == 0 && number2 % isGCD == 0) {
                result = isGCD;
            }
            isGCD--;
        }
        return result;
    }
}
