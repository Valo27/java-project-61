package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {
    public static void getGameQuestion() {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }

    public static String getTask() {
        int number = Engine.getRandomNumber(100);
        return String.valueOf(number);
    }

    public static boolean isPrime(int number) {
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

    public static boolean checkAnswer(String userAnswer, String task) {
        boolean isPrime = isPrime(Integer.parseInt(task));
        String correctAnswer = isPrime ? "yes" : "no";
        return userAnswer.equals(correctAnswer);
    }

    public static String getRightAnswer(String task) {
        boolean isPrime = isPrime(Integer.parseInt(task));
        return isPrime ? "yes" : "no";
    }
}
