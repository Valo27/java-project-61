package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {

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

    public static String getTask() {
        int number = Engine.getRandomNumber(100);
        return String.valueOf(number);
    }

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

    public static String getRightAnswer(String task) {
        boolean isPrime = isPrime(Integer.parseInt(task));
        return isPrime ? "yes" : "no";
    }
}
