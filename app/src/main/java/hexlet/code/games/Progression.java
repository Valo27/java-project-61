package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

/**
 * Класс для игры "Progression" - угадывание пропущенного числа в арифметической прогрессии.
 * Пользователь должен определить, какое число пропущено в последовательности.
 */
public class Progression {
    // Генератор случайных чисел
    private static final Random RANDOM = new Random();
    // Хранит пропущенное число для проверки ответа
    private static int hiddenNumber;

    // Константы для параметров прогрессии
    private static final int MIN_PROGRESSION_LENGTH = 5;
    private static final int MAX_PROGRESSION_LENGTH_DIFFERENCE = 6;
    private static final int MAX_STEP = 10;
    private static final int MAX_START_NUMBER = 20;

    /**
     * Запускает игру "Progression".
     * Выводит приветственное сообщение и запускает игровой процесс
     */
    public static void gameStart() {
        // Приветственное сообщение с инструкцией
        String greeting = "What number is missing in the progression?";
        Engine.getGreeting(greeting);

        // Запуск игрового процесса на заданное количество раундов
        for (int i = 0; i < Engine.getRounds(); i++) {
            // Генерируем задачу
            String task = getTask();
            // Получаем правильный ответ
            String current = getRightAnswer();
            // Запускаем игровой раунд
            Engine.gameRoutine(task, current);
        }

        Engine.win();
    }

    /**
     * Генерирует задачу - арифметическую прогрессию с пропущенным числом.
     *
     * @return строка с прогрессией, где пропущенное число заменено на ".."
     */
    public static String getTask() {
        // Генерируем параметры прогрессии
        int progressionLength = RANDOM.nextInt(MAX_PROGRESSION_LENGTH_DIFFERENCE) + MIN_PROGRESSION_LENGTH;
        int step = RANDOM.nextInt(MAX_STEP) + 1;
        int startNumber = RANDOM.nextInt(MAX_START_NUMBER) + 1;

        // Создаем массив для хранения прогрессии
        int[] progression = new int[progressionLength];
        // Заполняем массив значениями прогрессии
        for (int i = 0; i < progressionLength; i++) {
            progression[i] = startNumber + step * i;
        }

        // Выбираем случайный индекс для скрытия числа
        int hiddenIndex = RANDOM.nextInt(progressionLength);
        // Сохраняем пропущенное число
        hiddenNumber = progression[hiddenIndex];
        // Заменяем пропущенное число на 0
        progression[hiddenIndex] = 0;

        // Формируем строку с задачей
        StringBuilder task = new StringBuilder();
        for (int i = 0; i < progressionLength; i++) {
            if (progression[i] == 0) {
                task.append(".. "); // место пропущенного числа
            } else {
                task.append(progression[i]).append(" ");
            }
        }
        return task.toString().trim();
    }

    /**
     * Получает правильный ответ для сгенерированной задачи.
     *
     * @return правильный ответ в виде строки
     */
    public static String getRightAnswer() {
        return String.valueOf(hiddenNumber);
    }
}
