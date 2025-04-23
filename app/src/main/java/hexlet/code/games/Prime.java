package hexlet.code.games;

import hexlet.code.Engine;

/**
 * Класс для игры "Prime" - проверка чисел на простоту.
 */
public class Prime {

    /**
     * Начало игры чётное/нечётное
     */
    public static void gameStart() {
        //устанавливаем правила игры
        String greeting = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
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
     * Генерирует случайное число для задачи.
     *
     * @return случайное число
     */
    public static String getTask() {
        int number = Engine.getRandomNumber(100);
        return String.valueOf(number);
    }

    /**
     * Проверяет, является ли число простым.
     *
     * @param number проверяемое число
     * @return true, если число простое
     */
    public static boolean isPrime(int number) {
        if (number == 1) {
            return true;
        }
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Возвращает правильный ответ.
     *
     * @param task задача
     * @return правильный ответ
     */
    public static String getRightAnswer(String task) {
        boolean isPrime = isPrime(Integer.parseInt(task));
        return isPrime ? "yes" : "no";
    }
}
