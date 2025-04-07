package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    public static void getGameQuestion() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
    }

    public static int getTask() {
        return Engine.getRandomNumber();
    }

    public static boolean checkAnswer() {
        int task = Integer.parseInt(Engine.getTask());
        String answer = Engine.getAnswer();
        return (answer.equalsIgnoreCase("yes") && task % 2 == 0)
                || (answer.equalsIgnoreCase("no") && task % 2 != 0);
    }

    public static String getRightAnswer() {
        int task = Integer.parseInt(Engine.getTask());
        return task % 2 == 0 ? "yes" : "no";
    }
}
