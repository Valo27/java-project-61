package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {

    private static final int MAX_NUMBER = 100;

    public static void gameStart() {
        String greeting = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        Engine.getGreeting(greeting);

        // Запускаем ровно 3 раунда
        for (int i = 0; i < 3; i++) {
            String task = getTask();
            String correctAnswer = getRightAnswer(task);
            Engine.gameRoutine(task, correctAnswer);
        }

        Engine.win();
    }

    public static String getTask() {
        int number = Engine.getRandomNumber(MAX_NUMBER);
        return String.valueOf(number);
    }

    public static boolean isPrime(int number) {
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

    public static String getRightAnswer(String task) {
        boolean isPrime = isPrime(Integer.parseInt(task));
        return isPrime ? "yes" : "no";
    }
}
