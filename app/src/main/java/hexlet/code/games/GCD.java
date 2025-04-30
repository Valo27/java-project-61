package hexlet.code.games;

import hexlet.code.Engine;

/**
 * Класс для игры "GCD" - нахождение наибольшего общего делителя (НОД).
 * Пользователь должен найти НОД для двух заданных чисел.
 */
public class GCD {

    // Создаем константу для максимального значения чисел
    private static final int MAX_NUMBER = 100;

    /**
     * Запускает игру "GCD".
     * Выводит приветственное сообщение и запускает игровой процесс
     */
    public static void gameStart() {
        // Приветственное сообщение с инструкцией
        String greeting = "Find the greatest common divisor of given numbers.";
        Engine.getGreeting(greeting);

        // Запуск игрового процесса на заданное количество раундов
        for (int i = 0; i < Engine.getRounds(); i++) {
            // Генерируем задачу
            String task = getTask();
            // Получаем правильный ответ
            String current = getRightAnswer(task);
            // Запускаем игровой раунд
            Engine.gameRoutine(task, current);
        }

        Engine.win();
    }

    /**
     * Генерирует случайную задачу - пару чисел для вычисления НОД.
     *
     * @return строка с двумя случайными числами, разделенными пробелом
     */
    public static String getTask() {
        // Генерируем два случайных числа от 1 до MAX_NUMBER
        int num1 = Engine.getRandomNumber(MAX_NUMBER);
        int num2 = Engine.getRandomNumber(MAX_NUMBER);
        return num1 + " " + num2;
    }

    /**
     * Вычисляет наибольший общий делитель двух чисел.
     *
     * @param a первое число
     * @param b второе число
     * @return НОД для заданных чисел
     */
    public static int calculateGCD(int a, int b) {
        // Используем алгоритм Евклида для нахождения НОД
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /**
     * Получает правильный ответ для заданной задачи.
     *
     * @param task строка с двумя числами, разделенными пробелом
     * @return правильный ответ в виде строки
     */
    public static String getRightAnswer(String task) {
        // Разделяем строку на два числа
        String[] numbers = task.split(" ");
        int num1 = Integer.parseInt(numbers[0]);
        int num2 = Integer.parseInt(numbers[1]);
        // Вычисляем и возвращаем НОД
        return String.valueOf(calculateGCD(num1, num2));
    }
}
