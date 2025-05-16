package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.GameConfig;
import hexlet.code.Utils;

/**
 * Класс для игры "Калькулятор".
 * Генерирует математические выражения и проверяет их решения
 */
public class Calc {

    /**
     * Максимальное число для генерации случайных чисел.
     * Определяет диапазон чисел в математических выражениях
     */
    private static final int RANDOM_MAX_NUMBER = 100;

    /**
     * Массив математических операций.
     * Содержит доступные математические знаки для выражений
     */
    private static final String[] MATH_SIGNS = {"+", "-", "*"};

    /**
     * Основной метод запуска игры.
     * Создает вопросы и ответы для игры
     * Запускает игровой процесс
     */
    public static void gameCalc() {
        // Получаем количество раундов из конфигурации
        int rounds = GameConfig.getMaxRounds();

        // Создаем массив для хранения вопросов и ответов
        String[][] questAnswers = new String[rounds][2];

        // Приветственное сообщение для игры
        String greeting = "What is the result of the expression?";

        // Генерируем вопросы и ответы для всех раундов
        for (int i = 0; i < rounds; i++) {
            // Генерируем два случайных числа
            int number1 = Utils.random(RANDOM_MAX_NUMBER);
            int number2 = Utils.random(RANDOM_MAX_NUMBER);

            // Выбираем случайный математический знак
            int mathSign = Utils.random(0, MATH_SIGNS.length);

            // Формируем правильный ответ
            questAnswers[i][1] = answerProgression(mathSign, number1, number2);

            // Формируем вопрос (математическое выражение)
            questAnswers[i][0] = number1 + " " + MATH_SIGNS[mathSign] + " " + number2;
        }

        // Запускаем основной игровой процесс
        Engine.gameStart(greeting, questAnswers);
    }

    /**
     * Метод вычисления результата математического выражения.
     * @param mathSign индекс математического знака
     * @param number1 первое число
     * @param number2 второе число
     * @return результат вычисления в виде строки
     */
    private static String answerProgression(int mathSign, int number1, int number2) {
        String result;

        // Вычисляем результат в зависимости от математического знака
        result = switch (MATH_SIGNS[mathSign]) {
            case "+" -> Integer.toString(number1 + number2);
            case "-" -> Integer.toString(number1 - number2);
            case "*" -> Integer.toString(number1 * number2);
            default -> "";
        };

        return result;
    }
}
