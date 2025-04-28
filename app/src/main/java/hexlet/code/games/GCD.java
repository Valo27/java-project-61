package hexlet.code.games;

import hexlet.code.Engine;

public class GCD {

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

    public static String getTask() {
        int num1 = Engine.getRandomNumber(100);
        int num2 = Engine.getRandomNumber(100);
        return num1 + " " + num2;
    }

    public static int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static String getRightAnswer(String task) {
        String[] numbers = task.split(" ");
        int num1 = Integer.parseInt(numbers[0]);
        int num2 = Integer.parseInt(numbers[1]);
        return String.valueOf(calculateGCD(num1, num2));
    }
}
