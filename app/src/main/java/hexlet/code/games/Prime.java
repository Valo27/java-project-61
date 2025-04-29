package hexlet.code.games;

import hexlet.code.Engine;

/**
 * Класс для игры "Prime" - определение простых чисел.
 * Пользователь должен определить, является ли число простым.
 */
public class Prime {

    /**
     * Запускает игру "Prime".
     * Выводит приветственное сообщение и запускает игровой процесс
     */
    public static void gameStart() {
        // Приветственное сообщение с инструкцией
        String greeting = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        Engine.getGreeting(greeting);

        // Запуск игрового процесса на заданное количество раундов
        for (int i = 0; i < Engine.getRounds(); i++) {
            String task = getTask();
            String current = getRightAnswer(task);
            Engine.gameRoutine(task, current);
        }

        Engine.win();
    }

    /**
     * Генерирует случайное число для задачи.
     *
     * @return случайное число в диапазоне от 1 до 100
     */
    public static String getTask() {
        int number = Engine.getRandomNumber(100);
        return String.valueOf(number);
    }

    /**
     * Проверяет, является ли число простым.
     *
     * @param number проверяемое число
     * @return true если число простое, иначе false
     */
    public static boolean isPrime(int number) {
        // 1 считается простым числом в этой реализации
        if (number == 1) {
            return true;
        }
        // Числа меньше или равные 1 не являются простыми
        if (number <= 1) {
            return false;
        }
        // Проверяем делимость до корня из числа
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Получает правильный ответ для заданного числа.
     *
     * @param task число в виде строки
     * @return "yes" если число простое, "no" если нет
     */
    public static String getRightAnswer(String task) {
        boolean isPrime = isPrime(Integer.parseInt(task));
        return isPrime ? "yes" : "no";
    }
}
