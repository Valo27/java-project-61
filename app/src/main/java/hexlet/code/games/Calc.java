package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

/**
 * Класс для игры "Calc" - математические операции.
 * Кроме деления.
 */
public class Calc {

    private static final Random RANDOM = new Random();

    /**
     * Начало игры чётное/нечётное
     */
    public static void gameStart() {
        //устанавливаем правила игры
        String greeting = "What is the result of the expression?";
        //запускаем приветствие с передачей правил игры
        Engine.getGreeting(greeting);

        //запускаем раунды
        for (int i = 0; i < Engine.getRounds(); i++) {
            //устанавливаем вопрос
            String task = getTask();
            //устанавливаем верный ответ
            String current = getRightAnswer();
            //запускаем движок проверки ответа и передаём (вопрос, ответ)
            Engine.gameRoutine(task, current);
        }

        //выводим попеду
        Engine.win();
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
        int randomOperator = RANDOM.nextInt(3);
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
            default -> throw new IllegalStateException("Unexpected value: " + randomOperator);
        };
        return textOfTask;
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
