package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

/**
 * Класс для игры "Calc" - математические вычисления.
 * Пользователь должен решить математическое выражение и ввести ответ.
 */
public class Calc {

    // Генератор случайных чисел
    private static final Random RANDOM = new Random();

    // Константа для количества возможных операторов
    private static final int NUMBER_OF_OPERATORS = 3;

    /**
     * Запускает игру "Calc".
     * Выводит приветственное сообщение и запускает игровой процесс
     */
    public static void gameStart() {
        // Приветственное сообщение с инструкцией
        String greeting = "What is the result of the expression?";
        Engine.getGreeting(greeting);

        // Запуск игрового процесса на заданное количество раундов
        for (int i = 0; i < Engine.getRounds(); i++) {
            String task = getTask();
            String current = getRightAnswer();
            Engine.gameRoutine(task, current);
        }

        Engine.win();
    }

    // Хранит результат вычисления выражения
    private static Integer result;

    /**
     * Генерирует случайное математическое выражение.
     *
     * @return текстовое представление выражения
     */
    public static String getTask() {
        // Генерируем два случайных числа
        int num1 = Engine.getRandomNumber();
        int num2 = Engine.getRandomNumber();

        // Случайным образом выбираем оператор
        int randomOperator = RANDOM.nextInt(NUMBER_OF_OPERATORS);
        String textOfTask;

        // Создаем выражение в зависимости от выбранного оператора
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
     * Получает правильный ответ для сгенерированного выражения.
     *
     * @return правильный ответ в виде строки
     */
    public static String getRightAnswer() {
        return String.valueOf(result);
    }
}
