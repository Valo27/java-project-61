

package hexlet.code.games;

import java.util.Random;

/**
 * Класс для игры "Progression" - угадывание пропущенного числа в арифметической прогрессии
 */
public class Progression {
    private static final Random random = new Random();
    private static int hiddenNumber;
    private static int hiddenIndex;
    private static int[] progression;
    private static int progressionLength;
    private static int step;

    /**
     * Выводит правила игры
     */
    public static void getGameQuestion() {
        System.out.println("What number is missing in the progression?");
    }

    /**
     * Генерирует задачу с пропущенным числом в прогрессии
     */
    public static String getTask() {
        progressionLength = random.nextInt(6) + 5;
        step = random.nextInt(10) + 1;
        int startNumber = random.nextInt(20) + 1;

        progression = new int[progressionLength];
        for (int i = 0; i < progressionLength; i++) {
            progression[i] = startNumber + step * i;
        }

        hiddenIndex = random.nextInt(progressionLength);
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
     * Проверяет ответ пользователя
     */
    public static boolean checkAnswer(String answer) {
        return Integer.parseInt(answer) == hiddenNumber;
    }

    /**
     * Возвращает правильный ответ
     */
    public static String getRightAnswer() {
        return String.valueOf(hiddenNumber);
    }
}
