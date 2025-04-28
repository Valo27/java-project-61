package hexlet.code.games;

import hexlet.code.Engine;

public class Even {

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


    public static int getTask() {
        return Engine.getRandomNumber();
    }

    public static String checkAnswer(int task) {
        return task % 2 == 0 ? "yes" : "no";
    }
}
