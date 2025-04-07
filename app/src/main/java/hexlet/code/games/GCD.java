package hexlet.code.games;

import hexlet.code.Engine;

public class GCD {
    public static void getGameQuestion() {
        System.out.println("Find the greatest common divisor of given numbers.");
    }

    public static String getTask() {
        int num1 = Engine.getRandomNumber(100); // числа от 1 до 100
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

    public static boolean checkAnswer(String userAnswer, String task) {
        String[] numbers = task.split(" ");
        int num1 = Integer.parseInt(numbers[0]);
        int num2 = Integer.parseInt(numbers[1]);
        int correctAnswer = calculateGCD(num1, num2);
        return Integer.parseInt(userAnswer) == correctAnswer;
    }

    public static String getRightAnswer(String task) {
        String[] numbers = task.split(" ");
        int num1 = Integer.parseInt(numbers[0]);
        int num2 = Integer.parseInt(numbers[1]);
        return String.valueOf(calculateGCD(num1, num2));
    }
}
