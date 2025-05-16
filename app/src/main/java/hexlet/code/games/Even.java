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
     * Основной метод запуска игры.
     * Создает вопросы и ответы для игры
     * Запускает игровой процесс
     */
    public static void gameEven() {
        // Получаем количество раундов из конфигурации
        int rounds = GameConfig.getMaxRounds();

        // Создаем массив для хранения вопросов и ответов
        String[][] questAnswers = new String[rounds][2];

        // Приветственное сообщение для игры
        String greeting = "Answer 'yes' if the number is even, otherwise answer 'no'.";

        // Генерируем вопросы и ответы для всех раундов
        for (int i = 0; i < rounds; i++) {
            // Генерируем случайное число
            int number = Utils.random(RANDOM_MAX_NUMBER);

            // Формируем вопрос (число в виде строки)
            questAnswers[i][0] = Integer.toString(number);

            // Определяем правильный ответ ('yes' или 'no')
            questAnswers[i][1] = number % 2 == 0 ? "yes" : "no";
        }

        // Запускаем основной игровой процесс
        Engine.gameStart(greeting, questAnswers);
    }
}
