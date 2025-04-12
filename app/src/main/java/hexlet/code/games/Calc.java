package hexlet.code.games;

import hexlet.code.Engine;

/**
 * Класс для игры "Calc" - математические операции.
 * Кроме деления.
 */
public class Calc {

    /**
     * Выводит правила игры.
     */
    public static void getGameQuestion() {
        System.out.println("What is the result of the expression?");
    }

    private static Integer result;

    /**
     * Генерирует математическую задачу.
     *
     * @return строку с математическим выражением
     */
    public static String getTask() {
        int num1 = Engine.getRandomNumber();
        int num2 = Engine.getRandomNumber();
        int randomOperator = Engine.getRandomNumber(3);
        String textOfTask;

        textOfTask = switch (randomOperator) {
            case 0 -> {
                result = num1 + num2;
                yield num1 + " + " + num2;
            }
            case 1 -> {
                result = num1 - num2;
                yield num1 + " - " + num2;
            }
            case 2 -> {
                result = num1 * num2;
                yield num1 + " * " + num2;
            }
            default -> throw new IllegalStateException("Unknown operator!");
        };
        return textOfTask;
    }

    /**
     * Проверяет ответ пользователя.
     *
     * @return true, если ответ правильный, иначе false
     */
    public static boolean checkAnswer() {
        String answer = Engine.getAnswer();
        return String.valueOf(result).equals(answer);
    }

    /**
     * Возвращает правильный ответ.
     *
     * @return правильный ответ на задачу
     */
    public static String getRightAnswer() {
        return String.valueOf(result);
    }
}
