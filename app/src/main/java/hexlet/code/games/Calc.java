package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {
    public static void getGameQuestion() {
        System.out.println("What is the result of the expression?");
    }

    private static Integer result;
    public static String getTask() {
        int num1 = Engine.getRandomNumber();
        int num2 = Engine.getRandomNumber();
        int randomOperator = Engine.getRandomNumber(3);
        String textOfTask = "";

        switch (randomOperator) {
            case 1:
                result = num1 + num2;
                textOfTask = num1 + " + " + num2;
                break;
            case 2:
                result = num1 - num2;
                textOfTask = num1 + " - " + num2;
                break;
            case 3:
                result = num1 * num2;
                textOfTask = num1 + " * " + num2;
                break;
            default:
                result = 0;
                System.out.println("Unknown operator!");
                break;
        }
        return textOfTask;
    }

    public static boolean checkAnswer() {
        String answer = Engine.getAnswer();
        return (String.valueOf(result).equals(answer));
    }

    public static String getRightAnswer() {
        return String.valueOf(result);
    }
}
