package hexlet.code;

/**
 * Основной игровой движок для всех игр
 * Содержит логику запуска игры и проверки ответов
 */
public class Engine {

    /**
     * Основной метод запуска игры
     * @param greeting приветственное сообщение конкретной игры
     * @param questAnswers массив вопросов и правильных ответов [вопрос][правильный ответ]
     */
    public static void gameStart(String greeting, String[][] questAnswers) {

        // Имя игрока
        String nameGamer;

        // Приветственное сообщение
        System.out.println();
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");

        // Получаем имя игрока
        nameGamer = Utils.scannerString();
        System.out.println("Hello, " + nameGamer + "!");
        System.out.println(greeting);

        // Получаем количество раундов из конфигурации
        int rounds = GameConfig.getMaxRounds();

        // Основной игровой цикл
        for (int i = 0; i < rounds; i++) {
            // Выводим вопрос и получаем ответ игрока
            System.out.print("Question: " + questAnswers[i][0] + "\nYour answer: ");
            String playerAnswer = Utils.scannerString();

            // Проверяем правильность ответа
            if (playerAnswer.equals(questAnswers[i][1])) {
                System.out.println("Correct!");
            } else {
                // Если ответ неверный, выводим сообщение об ошибке
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n",
                        playerAnswer, questAnswers[i][1]);
                System.out.printf("Let's try again, %s!\n", nameGamer);
                System.exit(0);
            }
        }

        // Поздравление при успешной сдаче всех раундов
        System.out.printf("Congratulations, %s!\n", nameGamer);
    }
}
