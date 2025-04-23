package hexlet.code.games;

import hexlet.code.Engine;

/**
 * Класс для игры "GCD" - нахождение наибольшего общего делителя.
 */
public class GCD {

    /**
     * Начало игры чётное/нечётное
     */
    public static void gameStart() {
        //устанавливаем правила игры
        String greeting = "Find the greatest common divisor of given numbers.";
        //запускаем приветствие с передачей правил игры
        Engine.getGreeting(greeting);

        //запускаем раунды
        for (int i = 0; i < Engine.getRounds(); i++) {
            //устанавливаем вопрос
            String task = getTask();
            //устанавливаем верный ответ
            String current = getRightAnswer(task);
            //запускаем движок проверки ответа и передаём (вопрос, ответ)
            Engine.gameRoutine(task, current);
        }

        //выводим попеду
        Engine.win();
    }

    /**
     * Генерирует задачу с двумя числами.
     *
     * @return строку с двумя случайными числами
     */
    public static String getTask() {
        int num1 = Engine.getRandomNumber(100);
        int num2 = Engine.getRandomNumber(100);
        return num1 + " " + num2;
    }

    /**
     * Вычисляет НОД двух чисел.
     *
     * @param a первое число
     * @param b второе число
     * @return наибольший общий делитель чисел a и b
     */
    public static int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /**
     * Возвращает правильный ответ.
     *
     * @param task задача с двумя числами
     * @return правильный ответ (НОД двух чисел)
     */
    public static String getRightAnswer(String task) {
        String[] numbers = task.split(" ");
        int num1 = Integer.parseInt(numbers[0]);
        int num2 = Integer.parseInt(numbers[1]);
        return String.valueOf(calculateGCD(num1, num2));
    }
}
