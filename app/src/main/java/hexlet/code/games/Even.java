package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.GameConfig;
import hexlet.code.Utils;

/**
 * Класс для игры "Четное число".
 * Проверяет, является ли число четным
 */
public class Even {

    /**
     * Максимальное число для генерации случайных чисел.
     * Определяет диапазон чисел, которые будут проверяться на четность
     */
    private static final int RANDOM_MAX_NUMBER = 100;

    /**
     * Правила игры (константа класса).
     */
    private static final String GAME_RULES =
            "Answer 'yes' if the number is even, otherwise answer 'no'.";

    /**
     * Основной метод запуска игры.
     * Создает вопросы и ответы для игры
     * Запускает игровой процесс
     */
    public static void gameEven() {
        // Получаем количество раундов из конфигурации
        int rounds = GameConfig.getMaxRounds();

        // Создаем массив для хранения вопросов и ответов
        String[][] questAnswers = new String[rounds][2];

        // Генерируем вопросы и ответы для всех раундов
        for (int i = 0; i < rounds; i++) {
            // Генерируем случайное число
            int number = Utils.random(RANDOM_MAX_NUMBER);

            // Формируем вопрос (число в виде строки)
            questAnswers[i][0] = Integer.toString(number);

            // Определяем правильный ответ ('yes' или 'no')
            questAnswers[i][1] = isEven(number) ? "yes" : "no";
        }

        // Запускаем основной игровой процесс
        Engine.gameStart(GAME_RULES, questAnswers);
    }

    /**
     * Метод проверки числа на четность.
     * @param number проверяемое число
     * @return true если число четное, false если нечетное
     */
    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
