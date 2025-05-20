package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.GameConfig;
import hexlet.code.Utils;
import java.util.Arrays;

/**
 * Класс для игры "Арифметическая прогрессия".
 * Генерирует арифметические прогрессии и проверяет пропущенные числа.
 */
public class Progression {

    /**
     * Максимальное значение для шага прогрессии.
     */
    private static final int NUMBER_LAST = 10;

    /**
     * Минимальное значение для шага прогрессии.
     */
    private static final int NUMBER_FIRST_STEP_ONE = 2;

    /**
     * Минимальное значение для позиции пропущенного числа.
     */
    private static final int NUMBER_FIRST_STEP_TWO = 0;

    /**
     * Максимальное значение для первого числа прогрессии.
     */
    private static final int RANDOM_FIRST_NUMBER = 20;

    /**
     * Длина массива прогрессии.
     */
    private static final int MASSIVE_LENGTH = 10;

    /**
     * Правила игры (константа класса).
     */
    private static final String GAME_RULES =
            "What number is missing in the progression?";

    /**
     * Основной метод запуска игры.
     * Создает вопросы и ответы для игры.
     * Запускает игровой процесс.
     */
    public static void gameProgression() {
        // Получаем количество раундов из конфигурации
        int rounds = GameConfig.getMaxRounds();

        // Создаем массив для хранения вопросов и ответов
        String[][] questAnswers = new String[rounds][2];

        // Генерируем вопросы и ответы для всех раундов
        for (int i = 0; i < rounds; i++) {
            // Генерируем шаг прогрессии
            int step = Utils.random(NUMBER_FIRST_STEP_ONE, NUMBER_LAST);

            // Определяем позицию пропущенного числа
            int hiddenNumber = Utils.random(NUMBER_FIRST_STEP_TWO, NUMBER_LAST);

            // Генерируем первое число прогрессии
            int firstNumber = Utils.random(RANDOM_FIRST_NUMBER);

            // Создаем прогрессию
            int[] numbers = Arrays.copyOf(massiveProgression(firstNumber, step), MASSIVE_LENGTH);

            // Формируем правильный ответ
            questAnswers[i][1] = Integer.toString(numbers[hiddenNumber]);

            // Формируем вопрос (прогрессию с пропущенным числом)
            questAnswers[i][0] = massiveInStringProgression(numbers, hiddenNumber);
        }

        // Запускаем основной игровой процесс
        Engine.gameStart(GAME_RULES, questAnswers);
    }

    /**
     * Создает массив с арифметической прогрессией.
     * @param first первое число прогрессии
     * @param step шаг прогрессии
     * @return массив чисел арифметической прогрессии
     */
    private static int[] massiveProgression(int first, int step) {
        int[] numbers = new int[MASSIVE_LENGTH];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = first;
            first += step;
        }
        return numbers;
    }

    /**
     * Преобразует массив прогрессии в строку с пропущенным числом.
     * @param numbers массив чисел прогрессии
     * @param position позиция пропущенного числа
     * @return строка с прогрессией, где пропущенное число заменено на ".."
     */
    public static String massiveInStringProgression(int[] numbers, int position) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            if (i != position) {
                result.append(numbers[i]).append(" ");
            } else {
                result.append(".. ");
            }
        }
        return result.toString();
    }
}
