package hexlet.code.games;

import java.util.Random;

/**
 * Класс для игры "Progression" - угадывание пропущенного числа в арифметической прогрессии.
 */
public class Progression {
    private static final Random RANDOM = new Random();
    private static int hiddenNumber;

    /**
     * Выводит правила игры.
     */
    public static void getGameQuestion() {
        System.out.println("What number is missing in the progression?");
    }

    /**
     * Генерирует задачу с пропущенным числом в прогрессии.
     *
     * @return строку с арифметической прогрессией и пропущенным числом
     */
    public static String getTask() {
        int progressionLength = RANDOM.nextInt(6) + 5;
        int step = RANDOM.nextInt(10) + 1;
        int startNumber = RANDOM.nextInt(20) + 1;

        int[] progression = new int[progressionLength];
        for (int i = 0; i < progressionLength; i++) {
            progression[i] = startNumber + step * i;
        }

        int hiddenIndex = RANDOM.nextInt(progressionLength);
        hiddenNumber = progression[hiddenIndex];
        progression[hiddenIndex] = 0;

        StringBuilder task = new StringBuilder();
        for (int i = 0; i < progressionLength; i++) {
            if (progression[i] == 0) {
                task.append(".. ");
            } else {
                task.append(progression[i]).append(" ");
            }
        }
        return task.toString().trim();
    }

    /**
     * Проверяет ответ пользователя.
     *
     * @param answer ответ пользователя
     * @return true, если ответ правильный, иначе false
     */
    public static boolean checkAnswer(String answer) {
        return Integer.parseInt(answer) == hiddenNumber;
    }

    /**
     * Возвращает правильный ответ.
     *
     * @return правильный ответ (пропущенное число)
     */
    public static String getRightAnswer() {
        return String.valueOf(hiddenNumber);
    }
}
