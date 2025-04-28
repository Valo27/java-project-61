package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Progression {
    private static final Random RANDOM = new Random();
    private static int hiddenNumber;

    public static void gameStart() {
        //устанавливаем правила игры
        String greeting = "What number is missing in the progression?";
        //запускаем приветствие с передачей правил игры
        Engine.getGreeting(greeting);

        //запускаем раунды
        for (int i = 0; i < Engine.getRounds(); i++) {
            //устанавливаем вопрос
            String task = getTask();
            //устанавливаем верный ответ
            String current = getRightAnswer();
            //запускаем движок проверки ответа и передаём (вопрос, ответ)
            Engine.gameRoutine(task, current);
        }

        //выводим попеду
        Engine.win();
    }

    public static String getTask() {
        int progressionLength = RANDOM.nextInt(6) + 5;
        int step = RANDOM.nextInt(10) + 1;
        int startNumber = RANDOM.nextInt(20) + 1;

        int[] progression = new int[progressionLength];
        for (int i = 0; i < progressionLength; i++) {
            progression[i] = startNumber + step * i;
        }

        int hiddenIndex = RANDOM.nextInt(progressionLength);
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

    public static String getRightAnswer() {
        return String.valueOf(hiddenNumber);
    }
}
