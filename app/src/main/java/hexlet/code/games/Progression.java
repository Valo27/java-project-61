package hexlet.code.games;

import java.util.Random;

public class Progression {
    private static final Random random = new Random();
    private static int hiddenNumber;
    private static int hiddenIndex;
    private static int[] progression;
    private static int progressionLength;
    private static int step;

    public static void getGameQuestion() {
        System.out.println("What number is missing in the progression?");
    }

    public static String getTask() {
        progressionLength = random.nextInt(6) + 5;
        step = random.nextInt(10) + 1;
        int startNumber = random.nextInt(20) + 1;

        progression = new int[progressionLength];
        for (int i = 0; i < progressionLength; i++) {
            progression[i] = startNumber + step * i;
        }

        hiddenIndex = random.nextInt(progressionLength);
        hiddenNumber = progression[hiddenIndex];
        progression[hiddenIndex] = 0;

        StringBuilder task = new StringBuilder();
        for (int i = 0; i < progressionLength; i++) {
            if (progression[i] == 0) {
                task.append(".. ");
            } else {
                task.append(progression[i]).append(" ");
            }
        }
        return task.toString().trim();
    }

    public static boolean checkAnswer(String answer) {
        return Integer.parseInt(answer) == hiddenNumber;
    }

    public static String getRightAnswer() {
        return String.valueOf(hiddenNumber);
    }
}
