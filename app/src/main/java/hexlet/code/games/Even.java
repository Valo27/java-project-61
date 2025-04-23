package hexlet.code.games;

import hexlet.code.Engine;

/**
 * Класс для игры "Even" - проверка чисел на четность.
 */
public class Even {

    /**
     * Начало игры чётное/нечётное
     */
    public static void gameStart() {
        //устанавливаем правила игры
        String greeting = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        //запускаем приветствие с передачей правил игры
        Engine.getGreeting(greeting);

        //запускаем раунды
        for (int i = 0; i < Engine.getRounds(); i++) {
            //устанавливаем вопрос
            String task = String.valueOf(getTask());
            //устанавливаем верный ответ
            String current = checkAnswer(Integer.parseInt(task));
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
    public static int getTask() {
        return Engine.getRandomNumber();
    }

    /**
     * Возвращает правильный ответ.
     *
     * @return правильный ответ (yes или no)
     */
    public static String checkAnswer(int task) {
        return task % 2 == 0 ? "yes" : "no";
    }
}
