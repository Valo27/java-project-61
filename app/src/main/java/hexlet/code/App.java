package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

/**
 * Основной класс приложения, который управляет запуском различных игр.
 * Предоставляет меню выбора игр и обрабатывает пользовательский ввод.
 */
public class App {

    // Константы для вывода сообщений
    private static final String CHOICE_PROMPT = "Your choice: ";
    private static final String WELCOME_MESSAGE = "Please enter the game number and press Enter.";

    /**
     * Точка входа в приложение.
     * Выводит меню выбора игр и обрабатывает выбор пользователя.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        // Приветственное сообщение
        System.out.println(WELCOME_MESSAGE);

        // Вывод списка доступных игр
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");

        // Запрос выбора у пользователя
        System.out.print(CHOICE_PROMPT);

        // Получение выбора и запуск соответствующей игры
        String choice = Engine.getChoice();
        startChosenGame(choice);
        Engine.setClose();
    }

    /**
     * Запускает выбранную пользователем игру.
     *
     * @param choice строка с номером выбранной игры
     */
    public static void startChosenGame(String choice) {
        // Обработка выбора пользователя
        if (choice.equals("1")) {
            Engine.getGreeting("");  // Запуск приветствия
        }

        if (choice.equals("2")) {
            Even.gameStart();  // Запуск игры "Even"
        }

        if (choice.equals("3")) {
            Calc.gameStart();  // Запуск игры "Calc"
        }

        if (choice.equals("4")) {
            GCD.gameStart();  // Запуск игры "GCD"
        }

        if (choice.equals("5")) {
            Progression.gameStart();  // Запуск игры "Progression"
        }

        if (choice.equals("6")) {
            Prime.gameStart();  // Запуск игры "Prime"
        }

        if (choice.equals("0")) {
            System.out.println("Bye.");  // Выход из программы
        }
    }
}
