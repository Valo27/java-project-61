package hexlet.code.games;

import hexlet.code.Engine;

/**
 * Класс для игры "Even" - проверка чисел на четность.
 */
public class Even {

    /**
     * Выводит правила игры.
     */
    public static void getGameQuestion() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
    }

    /**
     * Генерирует случайное число для задачи.
     *
     * @return случайное число
     */
    public static int getTask() {
        return Engine.getRandomNumber();
    }

    /**
     * Проверяет ответ пользователя.
     *
     * @return true, если ответ правильный, иначе false
     */
    public static boolean checkAnswer() {
        int task = Integer.parseInt(Engine.getTask());
        String answer = Engine.getAnswer();
        return (answer.equalsIgnoreCase("yes") && task % 2 == 0)
                || (answer.equalsIgnoreCase("no") && task % 2 != 0);
    }

    /**
     * Возвращает правильный ответ.
     *
     * @return правильный ответ (yes или no)
     */
    public static String getRightAnswer() {
        int task = Integer.parseInt(Engine.getTask());
        return task % 2 == 0 ? "yes" : "no";
    }
}
