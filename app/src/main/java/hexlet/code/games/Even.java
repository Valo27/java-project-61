package hexlet.code.games;

import hexlet.code.Engine;

/**
 * Класс для игры "Even" - определение четных чисел.
 * Пользователь должен определить, является ли число четным.
 */
public class Even {

    /**
     * Запускает игру "Even".
     * Выводит приветственное сообщение и запускает игровой процесс
     */
    public static void gameStart() {
        // Приветственное сообщение с инструкцией
        String greeting = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        Engine.getGreeting(greeting);

        // Запуск игрового процесса на заданное количество раундов
        for (int i = 0; i < Engine.getRounds(); i++) {
            // Генерируем случайное число
            String task = String.valueOf(getTask());
            // Получаем правильный ответ
            String current = checkAnswer(Integer.parseInt(task));
            // Запускаем игровой раунд
            Engine.gameRoutine(task, current);
        }

        Engine.win();
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
     * Проверяет, является ли число четным.
     *
     * @param task проверяемое число
     * @return "yes" если число четное, "no" если нечетное
     */
    public static String checkAnswer(int task) {
        return task % 2 == 0 ? "yes" : "no";
    }
}
